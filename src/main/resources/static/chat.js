function sendMessage() {
        var messageInput = document.getElementById('message-input');
        var messageContent = messageInput.value;

        fetch('/sendMessage', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ messageContent: messageContent }),
        })
        .then(response => {
            console.log('Message sent successfully!');
            messageInput.value = ''; // Clear the input field after sending
        })
        .catch(error => {
            console.error('Error sending message:', error);
        });
    }