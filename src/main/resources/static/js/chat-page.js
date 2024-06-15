document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);

    const userId = parseInt(urlParams.get('userId'));
    if (!isNaN(userId)) {
        document.getElementById('userId').value = userId;
    }

    fetchChats(userId);

    document.getElementById('sendButton').addEventListener('click', function () {
        const messageContent = document.getElementById('messageInput').value;
        sendMessage(getCurrentChatId(), userId, messageContent);
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
            const messagesContainer = document.getElementById('messages');
            messagesContainer.innerHTML = '';

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
function getCurrentChatId() {
    const hash = window.location.hash;
    const match = hash.match(/#chat-(\d+)/);
    return match ? parseInt(match[1]) : null;
}

function sendMessage(chatId, userId, messageContent) {
    console.log('Sending message:', messageContent, 'to chat ID:', chatId, 'from user ID:', userId);

    fetch(`/api/messages/new-message`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            chatId: chatId,
            senderId: userId,
            messageContent: messageContent
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(message => {
            console.log('Message sent successfully:', message);
            document.getElementById('messageInput').value = '';

            const messagesContainer = document.getElementById('messages');
            appendMessageToContainer(message, messagesContainer, userId);
        })
        .catch(error => console.error('Error sending message:', error));
}

function appendMessageToContainer(message, container, userId) {
    const messageContainer = document.createElement('div');
    messageContainer.className = 'message';

    if (message.senderId === userId) {
        messageContainer.classList.add('message-sent');
    }

    const messageContent = document.createTextNode(message.messageContent);
    messageContainer.appendChild(messageContent);
    container.appendChild(messageContainer);
}