"use strict";

let createButton = document.querySelector("#createButton");
let updateButton = document.querySelector("#updateButton");

let resultsDiv = document.querySelector("#results-div");
let tbody = document.querySelector("#tbody1");

let fNameInput = document.querySelector("#firstNameInput");
let lNameInput = document.querySelector("#lastNameInput");
let tNameInput = document.querySelector("#teamInput");
let winsInput = document.querySelector("#winsInput");
let pFinishInput = document.querySelector("#pFinishInput");
let idInput = document.querySelector("#idInput");

let printResults = (result) => {
    let entryTR = document.createElement("tr");
    let entryTH = document.createElement("th");
    entryTH.setAttribute("scope", "row");
    entryTH.textContent = result.id;
    let entryName = document.createElement("td");
    entryName.textContent = (`${result.firstName} ${result.lastName}`);
    let entryTeam = document.createElement("td");
    entryTeam.textContent = result.team;
    let entryWins = document.createElement("td");
    entryWins.textContent = result.wins;
    let entryPodiums = document.createElement("td");
    entryPodiums.textContent = result.podiumFinishes;
    let delButton = document.createElement("button");
    delButton.textContent = "Delete";
    delButton.type = "button";
    delButton.setAttribute("class", "btn btn-danger btn-sm");
    delButton.setAttribute("onClick", `delThis(${result.id})`);

    
    entryTR.appendChild(entryTH);
    entryTR.appendChild(entryName);
    entryTR.appendChild(entryTeam);
    entryTR.appendChild(entryWins);
    entryTR.appendChild(entryPodiums);
    entryTR.appendChild(delButton);
    tbody.appendChild(entryTR);

}
let getAll = () => {
    axios.get("http://localhost:8080/driver/getAll")
    .then((response) => {

        tbody.innerHTML="";

        let results = response.data;
        for (let result of results){
            printResults(result);
        }
    })
    .catch((error) => { console.log(error); });
}

let create = () => {
    let obj = {
        "firstName": fNameInput.value,
        "lastName": lNameInput.value,
        "team": tNameInput.value,
        "wins": winsInput.value,
        "podiumFinishes": pFinishInput.value
    }

    axios.post("http://localhost:8080/driver/create", obj)
    .then(() => {
        getAll();
    })
    .catch((error) => { console.log(error); })
}

let update = () => {
    let obj = {
        "firstName": fNameInput.value,
        "lastName": lNameInput.value,
        "team": tNameInput.value,
        "wins": winsInput.value,
        "podiumFinishes": pFinishInput.value
    }


    axios.put(`http://localhost:8080/driver/update/${idInput.value}`, obj)
    .then(() => {
        getAll();
    })
    .catch((error) => { console.log(error); })
}

let delByID = () => {

    if (!validateDelete()) {
        return;
    }
    axios.delete(`http://localhost:8080/driver/delete/${idInput.value}`)
    .then(() => {
        
        getAll();
    })
    .catch((error) => { console.log(error); })
}

let delThis = (id) => {
    this.idInput = idInput;
    axios.delete(`http://localhost:8080/driver/delete/${id}`)
    .then(() => {
        
        getAll();
    })
    .catch((error) => { console.log(error); })
}

let validateDelete = () => {
    if (idInput.value === ""){
        alert("ID is required for this operation");
        return false;
    } else {
        return true;
    }
}

let validate = (type) => {

}


createButton.addEventListener("click", create);
updateButton.addEventListener("click", update);