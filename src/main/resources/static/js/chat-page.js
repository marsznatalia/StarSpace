document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);

    const userId = parseInt(urlParams.get('userId'));
    if (!isNaN(userId)) {
        document.getElementById('userId').value = userId;
    }

    fetchChats(userId);

});

function fetchChats(userId) {
    console.log('Fetching chats for user ID:', userId);
    fetch(`/api/users/${userId}/chats`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const contentType = response.headers.get('content-type');
            if (!contentType || !contentType.includes('application/json')) {
                throw new Error('Response is not JSON');
            }
            return response.json();
        })
        .then(chats => {
            console.log('Chats fetched successfully: ', chats);

            const chatsList = document.getElementsByClassName('contacts')[0];
            chatsList.innerHTML = '';

            chats.forEach(chat => {
                console.log('Processing chat: ', chat.chatName);
                const contact = document.createElement('a');
                contact.className = 'contact';
                contact.href = '#';
                contact.setAttribute('data-chat-id', chat.id);


                const contactInfo = document.createElement('div');
                contactInfo.className = 'contact-info';

                const contactName = document.createElement('div');
                contactName.className = 'contact-name';
                contactName.textContent = chat.chatName;
                contactInfo.appendChild(contactName);
                contact.appendChild(contactInfo);
                chatsList.appendChild(contact);

                fetchMessagesInChat(chat.id);

            })

        })
        .catch(error => console.error('Error fetching chats:', error));
}

function fetchMessagesInChat(chatId){
    console.log('Fetching chats for chat ID:', chatId);

    const messagesContainer = document.getElementsByClassName('messages')[0];
}