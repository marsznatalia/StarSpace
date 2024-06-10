document.addEventListener('DOMContentLoaded', function() {
    const messageInput = document.getElementById('messageInput');
    const sendButton = document.getElementById('sendButton');
    const messagesContainer = document.getElementById('messages');

    // Fetch chats when the DOM is loaded
    fetchChats();

    // Send message functionality
    sendButton.addEventListener('click', function() {
        const messageText = messageInput.value.trim();
        if (messageText !== '') {
            const messageElement = document.createElement('div');
            messageElement.classList.add('message', 'sent');

            const avatar = document.createElement('img');
            avatar.src = 'avatar-currentUser.jpg';
            avatar.alt = 'Avatar';
            avatar.classList.add('message-avatar');

            const messageContent = document.createElement('div');
            messageContent.classList.add('message-content');
            messageContent.textContent = messageText;

            messageElement.appendChild(avatar);
            messageElement.appendChild(messageContent);

            messagesContainer.appendChild(messageElement);

            messageInput.value = '';

            messagesContainer.scrollTop = messagesContainer.scrollHeight;
        }
    });

    // Send message on pressing Enter
    messageInput.addEventListener('keydown', function(event) {
        if (event.key === 'Enter') {
            sendButton.click();
        }
    });
});

// Function to fetch chats from the API
function fetchChats() {
    fetch('/api/chats')
        .then(response => response.json())
        .then(chats => {
            const chatsList = document.getElementsByClassName('contacts')[0];

            chats.forEach(chat => {
                const contact = document.createElement('div');
                contact.className = 'contact';

//                const avatar = document.createElement('img');
//                avatar.className = 'avatar';
//                avatar.src = chat.user.profilePicture;
//                avatar.alt = 'Avatar';

                const contactInfo = document.createElement('div');
                contactInfo.className = 'contact-info';

                const contactName = document.createElement('div');
                contactName.className = 'contact-name';
                contactName.textContent = chat.ChatName;

                contactInfo.appendChild(contactName);

//                contact.appendChild(avatar);
                contact.appendChild(contactInfo);

                chatsList.appendChild(contact);
            });
        })
        .catch(error => console.error('Error fetching chats:', error));
}
