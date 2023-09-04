// recruiter-dashboard.js
function logoutSession(){
  console.log("logout");
  localStorage.removeItem('token');
  window.location.href = 'login.html';
}


function onLoadDetails(){
  const token=localStorage.getItem('token');
  const userSession=getJWTPayload(token);
  console.log(userSession);
  document.getElementById('userName').innerText=userSession.userName;
}
function getJWTPayload(jwt) {
const [, payloadBase64] = jwt.split('.'); // Ignore header and signature
const payload = JSON.parse(atob(payloadBase64));
return payload;
}

// Function to fetch applicant details from the API
function fetchApplicants() {
  const apiUrl = "http://localhost:8081/applicants/get/all"; // Replace with the actual API URL

  return fetch(apiUrl)
    .then(response => response.json())
    .catch(error => console.error("Error fetching applicant data:", error));
}

// Function to create and populate an applicant card
function createApplicantCard(applicant) {
  const applicantCard = document.createElement("div");
  applicantCard.classList.add("col-md-10", "mb-4", "applicant-card");

  const applicantName = document.createElement("h3");
  applicantName.classList.add("applicant-name");
  applicantName.textContent = applicant.name;

  const applicantDetails = document.createElement("div");
  applicantDetails.classList.add("applicant-details");

  // Applicant details
  const details = [
    { label: "Username", value: applicant.username },
    { label: "Date of Birth", value: applicant.dob },
    { label: "Location", value: applicant.location },
    { label: "Email", value: applicant.email },
    { label: "Mobile", value: applicant.mobile },
    { label: "Current Organization", value: applicant.currentOrg },
    { label: "Gender", value: applicant.gender },
  ];

  details.forEach(detail => {
    const detailContainer = document.createElement("div");
    detailContainer.innerHTML = `<span class="label">${detail.label}:</span> ${detail.value}`;
    applicantDetails.appendChild(detailContainer);
  });

  // Call button
  const callBtn = document.createElement("button");
  callBtn.classList.add("call-btn", "btn", "btn-primary");
  callBtn.innerHTML = '<i class="fas fa-phone "></i><span class="button-text ml-2">Call</span>';
  callBtn.addEventListener("click", () => {
    window.location.href = `tel:${applicant.mobile}`;
  });

  // Mail button
  const mailBtn = document.createElement("button");
  mailBtn.classList.add("mail-btn", "btn", "btn-primary");
  mailBtn.innerHTML = '<i class="fas fa-envelope"></i> <span class="button-text ml-2">Mail</span>';
  mailBtn.addEventListener("click", () => {
    window.location.href = `mailto:${applicant.email}`;
  });

  // Button container
  const buttonContainer = document.createElement("div");
  buttonContainer.classList.add('button-container')
  buttonContainer.appendChild(callBtn);
  buttonContainer.appendChild(mailBtn);

  applicantCard.appendChild(applicantName);
  applicantCard.appendChild(applicantDetails);
  applicantCard.appendChild(buttonContainer);

  return applicantCard;
}

// Function to display applicant cards on the recruiter dashboard
function displayApplicants(applicants) {
  const applicantContainer = document.getElementById("applicantContainer");

  // Clear any existing applicant cards
  applicantContainer.innerHTML = "";

  // Create and populate applicant cards
  applicants.forEach(applicant => {
    const applicantCard = createApplicantCard(applicant);
    applicantContainer.appendChild(applicantCard);
  });
}

// Function to fetch applicant data and display on dashboard
function loadApplicantDetails() {
  fetchApplicants()
    .then(applicants => {
      if (applicants && applicants.length > 0) {
        displayApplicants(applicants);
      } else {
        console.log("No applicants found.");
      }
    })
    .catch(error => console.error("Error:", error));
}

// Call the function to fetch and display applicant details on page load
document.addEventListener("DOMContentLoaded", loadApplicantDetails);
function showModal(){
  window.location.href="create-job.html";
}




