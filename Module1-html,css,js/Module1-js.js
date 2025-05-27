// ==========================
// 1. JavaScript Setup
// ==========================
console.log("Welcome to the Community Portal");
window.onload = function () {
  alert("Page loaded successfully");
};

// ==========================
// 2. Event Data and Setup
// ==========================
class Event {
  constructor(name, date, category, seats) {
    this.name = name;
    this.date = new Date(date);
    this.category = category;
    this.seats = seats;
  }

  checkAvailability() {
    return this.seats > 0;
  }
}

const events = [
  new Event("Music Night", "2025-07-10", "music", 30),
  new Event("Art Workshop", "2024-01-01", "workshop", 0),
  new Event("Tech Talk", "2025-08-15", "workshop", 25),
  new Event("Sports Day", "2025-09-01", "sports", 10)
];

// ==========================
// 3. Filtering and Display
// ==========================
function displayEvents() {
  const eventList = document.getElementById("eventList");
  eventList.innerHTML = "";

  events.forEach((e, index) => {
    if (e.date > new Date() && e.checkAvailability()) {
      const card = document.createElement("div");
      card.className = "eventCard";
      card.innerHTML = `
        <h3>${e.name}</h3>
        <p>Date: ${e.date.toDateString()}</p>
        <p>Category: ${e.category}</p>
        <p>Seats: ${e.seats}</p>
        <button onclick="registerUser(${index})">Register</button>
      `;
      eventList.appendChild(card);
    }
  });
}

displayEvents();

// ==========================
// 4. Registration Handling
// ==========================
function registerUser(index) {
  try {
    if (events[index].seats > 0) {
      events[index].seats--;
      alert(`Registered for ${events[index].name}!`);
      displayEvents();
    } else {
      throw new Error("No seats available.");
    }
  } catch (err) {
    alert(err.message);
  }
}

// ==========================
// 5. Form Handling
// ==========================
document.getElementById("eventForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const name = e.target.name.value;
  const email = e.target.email.value;
  const phone = e.target.phone.value;
  const type = e.target.eventType.value;

  if (!name || !email || !phone) {
    document.getElementById("confirmation").innerText = "All fields are required.";
    return;
  }

  document.getElementById("confirmation").innerText = `Thanks for registering, ${name}!`;

  // Simulate server request
  setTimeout(() => {
    console.log("Form submitted:", { name, email, phone, type });
  }, 1000);

  // Save preference
  localStorage.setItem("preferredEvent", type);
});

// Load preferences
window.addEventListener("DOMContentLoaded", () => {
  const savedType = localStorage.getItem("preferredEvent");
  if (savedType) {
    document.getElementById("eventType").value = savedType;
  }
});

// Clear preferences
function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();
  alert("Preferences cleared.");
}

// ==========================
// 6. Input Validations
// ==========================
function validatePhone() {
  const phoneInput = document.getElementById("phone");
  if (!/^\d{10}$/.test(phoneInput.value)) {
    alert("Enter a valid 10-digit phone number.");
  }
}

// ==========================
// 7. Feedback & Events
// ==========================
function countChars() {
  const count = document.getElementById("feedbackText").value.length;
  document.getElementById("charCount").innerText = count;
}

function showFee() {
  const fee = document.getElementById("feeSelector").value;
  document.getElementById("feeDisplay").innerText = `Event Fee: ${fee}`;
}

function enlargeImage(img) {
  img.style.width = "300px";
  img.style.transition = "0.3s";
}

// ==========================
// 8. Video Event Handling
// ==========================
function showVideoReadyMessage() {
  document.getElementById("videoMessage").innerText = "Video ready to play!";
}

// ==========================
// 9. Geolocation
// ==========================
function getLocation() {
  const output = document.getElementById("locationOutput");

  if (!navigator.geolocation) {
    output.innerText = "Geolocation is not supported.";
    return;
  }

  navigator.geolocation.getCurrentPosition(
    (position) => {
      output.innerText = `Latitude: ${position.coords.latitude}, Longitude: ${position.coords.longitude}`;
    },
    (err) => {
      output.innerText = `Error: ${err.message}`;
    },
    {
      enableHighAccuracy: true,
      timeout: 5000,
      maximumAge: 0
    }
  );
}

// ==========================
// 10. Modern JS Features
// ==========================
function cloneEvents(eventList) {
  return [...eventList];
}

function extractEventDetails(event) {
  const { name, date, category, seats } = event;
  return `${name} - ${category} on ${new Date(date).toDateString()} (${seats} seats)`;
}

const formattedEvents = events.map(extractEventDetails);
console.log("Formatted Events:", formattedEvents);

// ==========================
// 11. AJAX Mock (Fetch Simulation)
// ==========================
function mockPostRegistration(data) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve({ status: 200, message: "Registered successfully!" });
    }, 2000);
  });
}

// Example use (simulated):
mockPostRegistration({ name: "Test", event: "Workshop" })
  .then(res => console.log("Mock server:", res.message))
  .catch(err => console.error("Mock error:", err));

// ==========================
// 12. jQuery Example (if included)
// ==========================
// Uncomment if jQuery is linked in HTML
/*
$(document).ready(function() {
  $('#registerBtn').click(function() {
    alert('Register button clicked');
  });

  $('.eventCard').fadeIn();
});
*/

// ==========================
// 13. Debugging Tips
// ==========================
// Use console.log() or breakpoints in DevTools
console.log("Script loaded completely. Inspect elements and check console for logs.");
