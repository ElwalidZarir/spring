
function sendLikes(postId, count) {
  const likeRequests = [];

  for (let i = 0; i < count; i++) {
    likeRequests.push(
      fetch(`http://localhost:8080/post/${postId}/like`, { method: 'PUT' })
    );
  }

  Promise.all(likeRequests)
    .then(() => {
      console.log(`${count} likes sent successfully!`);
    })
    .catch(error => {
      console.error('Failed to send likes:', error);
    });
}

sendLikes(1, 10);
