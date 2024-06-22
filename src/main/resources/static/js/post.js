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

                const postActions = document.createElement('div');
                postActions.className = 'post-actions';

                const likeButton = createActionButton('bx-like', 'Like');
                likeButton.addEventListener('click', () => console.log('Like clicked'));

                const commentButton = createActionButton('bx-comment', 'Comment');
                commentButton.addEventListener('click', () => console.log('Comment clicked'));

                const shareButton = createActionButton('bx-share', 'Share');
                shareButton.addEventListener('click', () => console.log('Share clicked'));

                const deleteButton = createActionButton('bx-trash', 'Delete');
                deleteButton.addEventListener('click', () => deletePost(post.id));

                const modifyButton = createActionButton('bx-edit', 'Modify');
                modifyButton.addEventListener('click', () => toggleEditForm(post.id));

                postActions.appendChild(likeButton);
                postActions.appendChild(commentButton);
                postActions.appendChild(shareButton);
                postActions.appendChild(deleteButton);
                postActions.appendChild(modifyButton);

                postContainer.appendChild(postHeader);
                postContainer.appendChild(postContent);
                postContainer.appendChild(postActions);

                if (post.image) {
                    const postImage = document.createElement('img');
                    postImage.className = 'post-image';
                    postImage.src = post.image;
                    postImage.alt = 'Post Image';
                    postContainer.appendChild(postImage);
                }

                const postEditForm = createEditForm(post.id, post.content);
                postContainer.appendChild(postEditForm);

                postsList.appendChild(postContainer);
            });
        })
        .catch(error => console.error('Error fetching posts:', error));
}

function createActionButton(iconClass, tooltip) {
    const button = document.createElement('button');
    button.className = 'post-action';
    button.innerHTML = `<i class='bx ${iconClass}'></i> ${tooltip}`;
    return button;
}

function createEditForm(postId, currentContent) {
    const editFormContainer = document.createElement('div');
    editFormContainer.className = 'post-edit-form-container';

    const editForm = document.createElement('div');
    editForm.className = 'post-edit-form';
    editForm.innerHTML = `
        <input type="text" id="editContent-${postId}" class="edit-post-input" value="${currentContent}">
        <button onclick="submitEditPost(${postId})" class="edit-post-button">Save</button>
    `;
    editForm.style.display = 'none'; // Initially hidden
    editForm.id = `post-edit-form-${postId}`;

    editFormContainer.appendChild(editForm);

    return editFormContainer;
}

function addPost(userAuthorId) {
    const content = document.getElementById('postContent').value;
    console.log('UserAuthorId:', userAuthorId);  // Debugging line
    console.log('Content:', content);  // Debugging line

    fetch('/api/post/add-post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ userAuthorId, content }),
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
    const editForm = document.getElementById(`post-edit-form-${postId}`);
    if (editForm.style.display === 'none') {
        editForm.style.display = 'block';
    } else {
        editForm.style.display = 'none';
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