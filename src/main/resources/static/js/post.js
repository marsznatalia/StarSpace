
    document.addEventListener("DOMContentLoaded", function() {
        fetchPosts();
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
                    postAvatar.src = post.user.profilePicture;
                    postAvatar.alt = 'Avatar';

                    const postUsername = document.createElement('div');
                    postUsername.className = 'post-username';
                    postUsername.textContent = post.user.userName;

                    postHeader.appendChild(postAvatar);
                    postHeader.appendChild(postUsername);

                    const postContent = document.createElement('div');
                    postContent.className = 'post-content';
                    postContent.textContent = post.content;

                    postContainer.appendChild(postHeader);
                    postContainer.appendChild(postContent);

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

                    const commentButton = document.createElement('button');
                    commentButton.className = 'post-action';
                    commentButton.innerHTML = "<i class='bx bx-comment'></i> Comment";

                    const shareButton = document.createElement('button');
                    shareButton.className = 'post-action';
                    shareButton.innerHTML = "<i class='bx bx-share'></i> Share";

                    postActions.appendChild(likeButton);
                    postActions.appendChild(commentButton);
                    postActions.appendChild(shareButton);

                    postContainer.appendChild(postActions);

                    postsList.appendChild(postContainer);
                });
            })
            .catch(error => console.error('Error fetching posts:', error));
    }