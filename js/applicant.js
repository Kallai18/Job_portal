
document.addEventListener('DOMContentLoaded', () => {
    function searchJobs() {
      const searchInput = document.querySelector('.search-input');
      const filter = searchInput.value.toUpperCase();
      const jobCards = document.querySelectorAll('.job-card');
    
      jobCards.forEach(card => {
        if (card.hasAttribute('data-job')) {
          const jobTitle = card.dataset.job.toUpperCase();
          if (jobTitle.includes(filter)) {
            card.style.display = 'block';
          } else {
            card.style.display = 'none';
          }
        }
      });
    }

    //function for logout
    function logotSession(){
        console.log("logout");
        localStorage.removeItem('token');
        window.location.href = 'login.html';
    }

    //function to decode to jwt
    function getJWTPayload(jwt) {
      const [, payloadBase64] = jwt.split('.'); // Ignore header and signature
      const payload = JSON.parse(atob(payloadBase64));
      return payload;
    }


    function displayJobs(jobs) {
      const jobContainer = document.getElementById("jobContainer");
    
      // Clear any existing job cards
      jobContainer.innerHTML = "";
    
      // Create and populate job cards
      jobs.forEach(job => {
        const jobCard = createJobCard(job);
        jobContainer.appendChild(jobCard);
      });
    }



    // Function to apply for a job
function applyForJob(jobId, userId) {
  const apiUrl = "http://localhost:8081/job-application/apply"; // Replace with the actual API URL

  const requestBody = {
    jobId: jobId,
    userId: userId
  };

  fetch(apiUrl, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(requestBody)
  })
    .then(res => {
      // Handle the response data, e.g., show a success message
    if(res.ok){
      showToast("Application submitted successfully","success")
      console.log("Application submitted successfully:", data);
    }
    })
    .catch(error => console.error("Error applying for job:", error));
}

    function onLoadFunction(){
      const token=localStorage.getItem('token');
      let userSession=getJWTPayload(token);
      console.log(userSession);
      let userName= userSession.userName;
     const userNameElement= document.getElementById('userName');
     userNameElement.innerText=""+userName;

     fetchJobsFromAPI()
    .then(jobs => {
      if (jobs && jobs.length > 0) {
        displayJobs(jobs);

        // Add event listeners to the "Apply Now" buttons
        const applyBtns = document.querySelectorAll(".job-apply-btn");
        applyBtns.forEach(btn => {
          btn.addEventListener("click", () => {
            // Get the jobId and userId from the data attributes of the job card
           
            const jobId = btn.parentElement.getAttribute("data-jobid");
            const userSession = getJWTPayload(localStorage.getItem('token')); // Replace this with the actual user ID (if available)
      
            // Call the function to apply for the job
            applyForJob(jobId, userSession.userId);
          });
        });
      } else {
        // If there are no jobs, you can display a message or take appropriate action.
        console.log("No jobs found.");
      }
    })
    .catch(error => console.error("Error:", error));
    }
  
  
    window.addEventListener("load", onLoadFunction);
    const searchInput = document.querySelector('.search-input');
    searchInput.addEventListener('keyup', searchJobs);
    const logout=document.getElementById('logout');
    logout.addEventListener('click',logotSession);
    const token = localStorage.getItem('token');
    console.log(token);
    if (!token) {
    window.location.href = 'login.html';
  }




  // Function to fetch job data from the API
function fetchJobsFromAPI() {
  const apiUrl = "http://localhost:8081/jobs/get/all"; // Replace with the actual API URL

  return fetch(apiUrl)
    .then(response => response.json())
    .catch(error => console.error("Error fetching data:", error));
}

// Function to create and populate a job card
function createJobCard(job) {
  const jobCard = document.createElement("div");
  jobCard.classList.add("job-card");
  jobCard.setAttribute('data-job',job.jobTitle)
  const jobTitle = document.createElement("div");


  jobTitle.classList.add("job-title");
  jobTitle.textContent = job.jobTitle;

  const jobCompany = document.createElement("div");
  jobCompany.classList.add("job-company");
  jobCompany.textContent = `Posted by: ${job.postedBy}`;

  const jobDescription = document.createElement("div");
  jobDescription.classList.add("job-description");
  jobDescription.textContent = job.description;

  const applyBtn = document.createElement("a");
  applyBtn.classList.add("job-apply-btn");
  applyBtn.textContent = "Apply Now";
  jobCard.setAttribute("data-jobid", job.jobId);

  jobCard.appendChild(jobTitle);
  jobCard.appendChild(jobCompany);
  jobCard.appendChild(jobDescription);
  jobCard.appendChild(applyBtn);

  return jobCard;
}




// Function to display a toast notification with a message
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


  });



  