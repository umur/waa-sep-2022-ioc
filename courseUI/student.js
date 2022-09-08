async function fetchStudent() {
    fetch('http://localhost:8080/students')

    .then((response) => response.json())
    .then(
        (data) => {
            console.log(data)
            for(let e of data){
                
            let li = document.createElement('li')
            var button = document.createElement("button");
            button.setAttribute('class','btn btn-danger float-right')
            button.innerHTML = "delete";
            li.setAttribute('class','list-group-item');
            li.innerText = "name :" + e.firstName + " " + e.lastName +", major "+ e.major + ", gpa : " + e.gpa + " email : " + e.email;
            document.getElementById('ulContainer').append(li);
            li.appendChild(button);
            button.onclick = function(event) {
               alert("de")
               url = "http://localhost:8080/students/1";
  
                // Awaiting fetch which contains 
                // method, headers and content-type
                fetch(url)
                .then((response) => response.json())
                .then((res) => console.log(res))
                .catch((err) => console.log(err));
            
              }
            }
        
        }
        
        );
    
}


function sendData () {
   debugger;


   var xhr = new XMLHttpRequest();
   var url = "http://localhost:8080/students";
   xhr.open("POST", url, true);
   xhr.setRequestHeader("Content-Type", "application/json");
   xhr.onreadystatechange = function () {
       if (xhr.readyState === 4 && xhr.status === 200) {
           var json = JSON.parse(xhr.responseText);
           console.log(json.email + ", " + json.password);
       }
   };
   var data = JSON.stringify({  
    "firstName": document.getElementById("firstName").value,
    "lastName": document.getElementById("lastName").value,
    "email": document.getElementById("email").value,
    "major": document.getElementById("major").value,
    "gpa": document.getElementById("gpa").value 
});
   xhr.send(data);

  }

fetchStudent();
