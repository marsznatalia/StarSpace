document.addEventListener("DOMContentLoaded", function () {
    fetchPosts();
    const urlParams = new URLSearchParams(window.location.search);

    const userAuthorId = parseInt(urlParams.get('userId'));
    if (!isNaN(userAuthorId)) {
        document.getElementById('userAuthorId').value = userAuthorId;
    }
    console.log('UserAuthorID:', userAuthorId);

    document.getElementById('addPostForm').addEventListener('submit', function (event) {
        event.preventDefault();
        addPost(userAuthorId);
    });


});

function fetchPosts() {
    fetch('/api/posts')
        .then(response => response.json())
        .then(posts => {
            const postsList = document.getElementsByClassName('posts-list')[0];
            postsList.innerHTML = '';

            posts.forEach(post => {
                const postContainer = document.createElement('div');
                postContainer.className = 'post-container';

                const postHeader = document.createElement('div');
                postHeader.className = 'post-header';

                const postAvatar = document.createElement('img');
                postAvatar.className = 'post-avatar';
                // postAvatar.src = post.user.profilePicture;
                postAvatar.alt = 'Avatar';

                const postUsername = document.createElement('div');
                postUsername.className = 'post-username';
                postUsername.textContent = post.user.userName;

                postHeader.appendChild(postAvatar);
                postHeader.appendChild(postUsername);

                const postContent = document.createElement('div');
                postContent.className = 'post-content';
                postContent.textContent = post.content;
                postContent.id = `post-content-${post.id}`;

                const postEditForm = document.createElement('div');
                postEditForm.className = 'post-edit-form';
                postEditForm.innerHTML = `
                    <input type="text" id="editContent-${post.id}" class="edit-post-input" value="${post.content}">
                    <button onclick="submitEditPost(${post.id})" class="edit-post-button">Save</button>
                `;
                postEditForm.style.display = 'block';
                postEditForm.id = `post-edit-form-${post.id}`;

                postContainer.appendChild(postHeader);
                postContainer.appendChild(postContent);
                postContainer.appendChild(postEditForm);

                if (post.image) {
                    const postImage = document.createElement('img');
                    postImage.className = 'post-image';
                    postImage.src = post.image;
                    postImage.alt = 'Post Image';
                    postContainer.appendChild(postImage);
                }

                const postActions = document.createElement('div');
                postActions.className = 'post-actions';

                const likeButton = document.createElement('button');
                likeButton.className = 'post-action';
                likeButton.innerHTML = "<i class='bx bx-like'></i> Like";


                const deleteButton = document.createElement('button');
                deleteButton.className = 'post-action';
                deleteButton.innerHTML = "<i class='bx bx-trash'></i> Delete";
                deleteButton.addEventListener('click', function() {
                    deletePost(post.id);
                });

                const commentButton = document.createElement('button');
                commentButton.className = 'post-action';
                commentButton.innerHTML = "<i class='bx bx-comment'></i> Comment";

                const shareButton = document.createElement('button');
                shareButton.className = 'post-action';
                shareButton.innerHTML = "<i class='bx bx-share'></i> Share";

                postActions.appendChild(likeButton);
                postActions.appendChild(commentButton);
                postActions.appendChild(shareButton);
                postActions.appendChild(deleteButton);

                postContainer.appendChild(postActions);

                postsList.appendChild(postContainer);
            });
        })
        .catch(error => console.error('Error fetching posts:', error));
}

function addPost(userAuthorId) {

    const content = document.getElementById('postContent').value;
    console.log('UserAuthorId:', userAuthorId);  // Debugging line
    console.log('Content:', content);  // Debugging line
    parseInt(userAuthorId);
    fetch('/api/post/add-post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({userAuthorId, content}),
    })
        .then(response => {
            if (response.ok) {
                fetchPosts();
                document.getElementById('postContent').value = '';
            } else {
                console.error('Error adding post');
            }
        })
        .catch(error => console.error('Error adding post:', error));
}

function deletePost(postId) {
    console.log('Deleting post with ID:', postId);
    fetch(`/api/post/delete-post/${postId}`, {
        method: 'DELETE',
    })
        .then(response => {
            if (response.ok) {
                console.log('Post deleted successfully');
                fetchPosts();
            } else {
                console.error('Error deleting post');
            }
        })
        .catch(error => console.error('Error deleting post:', error));
}


function toggleEditForm(postId) {
    const postContent = document.getElementById(`post-content-${postId}`);
    const postEditForm = document.getElementById(`post-edit-form-${postId}`);
    if (postEditForm.style.display === 'none') {
        postEditForm.style.display = 'block';
        postContent.style.display = 'none';
    } else {
        postEditForm.style.display = 'none';
        postContent.style.display = 'block';
    }
}

function submitEditPost(postId) {
    const editedContent = document.getElementById(`editContent-${postId}`).value;
    console.log('Editing post with ID:', postId);  // Debugging line
    console.log('Edited content:', editedContent);  // Debugging line

    fetch(`/api/post/edit-post/${postId}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ content: editedContent }),
    })
        .then(response => {
            if (response.ok) {
                console.log('Post edited successfully');
                fetchPosts(); // Refresh the posts list after editing
            } else {
                console.error('Error editing post');
            }
        })
        .catch(error => console.error('Error editing post:', error));
}