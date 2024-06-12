document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);

    const userId = parseInt(urlParams.get('userId'));
    if (!isNaN(userId)) {
        document.getElementById('userId').value = userId;
    }

    fetchChats(userId);

    document.getElementById('sendButton').addEventListener('click', function () {
        const messageContent = document.getElementById('messageInput').value;
        const chatId = getCurrentChatId();

        if (messageContent && chatId) {
            sendMessage(chatId, userId, messageContent);
        }
    });

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
                contact.href = `#chat-${chat.id}`;
                contact.setAttribute('data-chat-id', chat.id);
                contact.onclick = () => fetchMessagesInChat(chat.id, userId);

                const contactInfo = document.createElement('div');
                contactInfo.className = 'contact-info';

                const contactName = document.createElement('div');
                contactName.className = 'contact-name';
                contactName.textContent = chat.chatName;
                contactInfo.appendChild(contactName);
                contact.appendChild(contactInfo);
                chatsList.appendChild(contact);


            })

        })
        .catch(error => console.error('Error fetching chats:', error));
}

function fetchMessagesInChat(chatId, userId) {
    console.log('Fetching messages for chat ID:', chatId);
    fetch(`/api/messages/${chatId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(messages => {
            console.log("Fetch successfull!");
            const messagesContainer = document.getElementById('messages'); // Get the messages container
            messagesContainer.innerHTML = ''; // Clear existing messages

            messages.forEach(message => {
                const messageContainer = document.createElement('div');
                messageContainer.className = 'message';
                if (message.senderId === userId) {
                    console.log("Message", message.messageContent, "added as the ids are the same.", message.senderId, userId);
                    messageContainer.className = 'message.sent';
                }
                const messageContent = document.createTextNode(message.messageContent);
                messageContent.className = 'message-content';
                messageContainer.appendChild(messageContent);
                messagesContainer.appendChild(messageContainer);
            });
        })
        .catch(error => console.error('Error fetching messages:', error));
}


