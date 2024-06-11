document.addEventListener('DOMContentLoaded', function () {
  const messageInput = document.getElementById('messageInput');
  const sendButton = document.getElementById('sendButton');
  const messagesContainer = document.getElementById('messages');
  const chatsList = document.getElementsByClassName('contacts')[0];

  // Fetch chats when the DOM is loaded
  fetchChats();
  loadMessages(chatId);

  sendButton.addEventListener('click', function () {
    sendMessage();
  });

  messageInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
      sendButton.click();
    }
  });
});

function fetchChats() {
  fetch('/api/chats')
    .then(response => response.json())
    .then(chats => {
      const chatsList = document.getElementsByClassName('contacts')[0];
      chatsList.innerHTML = '';

      chats.forEach(chat => {
        const contact = document.createElement('a');
        contact.className = 'contact';
        contact.href = '#';
        contact.setAttribute('data-chat-id', chat.id);
        contact.onclick = function () {
          selectChat(this);
        };

        const contactInfo = document.createElement('div');
        contactInfo.className = 'contact-info';

        const contactName = document.createElement('div');
        contactName.className = 'contact-name';
        contactName.textContent = chat.chatName;
        contactInfo.appendChild(contactName);
        contact.appendChild(contactInfo);
        chatsList.appendChild(contact);
      });

      if (chats.length > 0) {
        loadMessages(chats[0].id, chats[0].chatName);
      }
    })
    .catch(error => console.error('Error fetching chats:', error));
}

function selectChat(element) {
  const chatId = element.getAttribute('data-chat-id');
  const chatName = element.querySelector('.contact-name').textContent;
  loadMessages(chatId, chatName);
}

function loadMessagesForFirstChat() {
  const firstChat = document.querySelector('.contacts .contact');
  if (firstChat) {
    selectChat(firstChat);
  }
}

function loadMessages(chatId) {
  fetch('/api/messages${chatId}')
    .then(response => response.json())
    .then(messages => {
      messagesContainer.innerHTML = '';
      messages.forEach(message => {
        const messageElement = document.createElement('div');
        messageElement.classList.add(
          'message',
          message.senderId === currentUser.id ? 'sent' : 'received'
        );

        const messageContent = document.createElement('div');
        messageContent.classList.add('message-content');
        messageContent.textContent = message.messageContent;

        messageElement.appendChild(messageContent);
        messagesContainer.appendChild(messageElement);
      });
      messagesContainer.scrollTop = messagesContainer.scrollHeight;
    })
    .catch(error => console.error('Error fetching messages: ', error));

  //    // Send message functionality
  //    sendButton.addEventListener('click', function() {
  //        const messageText = messageInput.value.trim();
  //        if (messageText !== '') {
  //            const messageElement = document.createElement('div');
  //            messageElement.classList.add('message', 'sent');
  //
  ////            const avatar = document.createElement('img');
  ////            avatar.src = 'avatar-currentUser.jpg';
  ////            avatar.alt = 'Avatar';
  ////            avatar.classList.add('message-avatar');
  //
  //            const messageContent = document.createElement('div');
  //            messageContent.classList.add('message-content');
  //            messageContent.textContent = messageText;
  //
  ////            messageElement.appendChild(avatar);
  //            messageElement.appendChild(messageContent);
  //
  //            messagesContainer.appendChild(messageElement);
  //
  //            messageInput.value = '';
  //
  //            messagesContainer.scrollTop = messagesContainer.scrollHeight;
  //        }
  //    }

  function sendMessage() {
    const messageText = messageInput.value.trim();
    if (messageText !== '') {
      const messageElement = document.createElement('div');
      messageElement.classList.add('message', 'sent');

      const messageContent = document.createElement('div');
      messageContent.classList.add('message-content');
      messageContent.textContent = messageText;

      messageElement.appendChild(messageContent);

      messagesContainer.appendChild(messageElement);

      messageInput.value = '';

      messagesContainer.scrollTop = messagesContainer.scrollHeight;
    }
  }

  function selectChat(element) {
      const chatId = element.getAttribute('data-chat-id');
      console.log('Selected chat ID:', chatId);
      const url = `/chat?id=${chatId}`;
      console.log('New URL:', url);
      window.history.pushState({}, '', url);
      console.log('URL updated');
      loadMessages(chatId);
  }


}
