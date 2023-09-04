function showToast(message, type) {
    const toastElement = document.getElementById('toastMessage');
  
    // Clear any existing classes to reset the toast
    toastElement.classList.remove('success', 'error');
  
    // Add different styles for error and success messages
    if (type === 'error') {
      toastElement.classList.add('error');
    } else if (type === 'success') {
      toastElement.classList.add('success');
    }
  
    const toastTextElement = toastElement.querySelector('.toast-text');
    toastTextElement.innerText = message;
    toastElement.style.display = 'block';
  
    // Add animation by setting opacity to 1 and sliding in from right
    setTimeout(() => {
      toastElement.style.opacity = 1;
      toastElement.style.right = '50%'; // Slide in to the center
    }, 100);
  
    // Hide the toast after 3 seconds (adjust the timeout as needed)
    setTimeout(() => {
      toastElement.style.opacity = 0;
      toastElement.style.right = '20px'; // Slide out to the left
  
      // Delay removing the toast to allow for the slide-out animation
      setTimeout(() => {
        toastElement.style.display = 'none';
      }, 500);
    }, 3000);
  }
  