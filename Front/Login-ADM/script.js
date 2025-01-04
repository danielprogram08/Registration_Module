function login() {
    const name = document.getElementById('name').value;
    const password = document.getElementById('password').value;
    let spinner = document.getElementById('spinner');
    let TitleBtn = document.getElementById('title-btn');
    let btnLogin = document.getElementById('btn-login');

    // Show the loading spinner;
    spinner.classList.remove('d-none');
    TitleBtn.textContent = '';
    btnLogin.disabled = true;

    if (name == "" && password == "" || name == "" || password == "") {
        let alert = document.createElement("div");
        let container = document.querySelector(".container");
        alert.innerHTML =
            `<div style="position: fixed; top: 0; width: 100%; text-align: center;" class="alert alert-danger" role="alert">
                𝗣𝗿𝗲𝗲𝗻𝗰𝗵𝗮 𝘁𝗼𝗱𝗼𝘀 𝗼𝘀 𝗰𝗮𝗺𝗽𝗼𝘀!
            </div>`;
        container.style.marginTop = "20px"; // add margin above of the container;
        document.body.appendChild(alert);
        document.body.insertBefore(alert, document.body.firstChild) // add the alert in first position;
        // Hide the loading spinner;
        spinner.classList.add('d-none');
        TitleBtn.textContent = 'login';
        btnLogin.disabled = false;

    } else {
        // Show the loading spinner;
        spinner.classList.remove('d-none');
        TitleBtn.textContent = '';
        btnLogin.disabled = true;

        fetch(`http://localhost:8080/Administrator/${name}/${password}`)
            // 1. Trying the request to Back-End; 
            .then(response => {
                if (!response.ok) {
                    throw new Error('Erro na requisição');
                }
                return response.json(); // Convert the response in json;
            })

            // 2. Response and logic of the front;
            .then(data => {
                if (data == null) {
                    let alertAdm = document.createElement("div");
                    let container = document.querySelector(".container");

                    alertAdm.innerHTML =
                        `<div style="position: fixed; top: 0; width: 100%; text-align: center;" class="alert alert-danger" role="alert">
                        𝗔𝗱𝗺𝗶𝗻𝗶𝘀𝘁𝗿𝗮𝗱𝗼𝗿 𝗻ã𝗼 𝗲𝗻𝗰𝗼𝗻𝘁𝗿𝗮𝗱𝗼!
                    </div>`;
                    container.style.marginTop = "20px";
                    document.body.appendChild(alertAdm);
                    document.body.insertBefore(alertAdm, document.body.firstChild);
                }
                console.log(data);
                let alertSucess = document.createElement("div");
                let container = document.querySelector(".container");
                alertSucess.innerHTML =
                    `<div style="position: fixed; top: 0; width: 100%; text-align: center;" class="alert alert-success" role="alert">
                        ✔️ 𝗕𝗲𝗺-𝗩𝗶𝗻𝗱𝗼!
                    </div>`
                container.style.marginTop = "20px";
                document.body.appendChild(alertSucess);
                document.body.insertBefore(alertSucess, document.body.firstChild);

                clear();
                // Hide the loading spinner;
                spinner.classList.add('d-none');
                TitleBtn.textContent = 'login';
                btnLogin.disabled = false;
            })
            .catch(error => {
                console.error('Erro:', error);
                // Show error message;
                let alert = document.createElement("div");
                let container = document.querySelector(".container");
                alert.innerHTML =
                    `<div style="position: fixed; top: 0; width: 100%; text-align: center;" class="alert alert-danger" role="alert">
                        𝗘𝗿𝗿𝗼 𝗮𝗼 𝗳𝗮𝘇𝗲𝗿 𝗹𝗼𝗴𝗶𝗻!
                    </div>`;
                container.style.marginTop = "20px"; // add margin above of the container;
                document.body.appendChild(alert);
                document.body.insertBefore(alert, document.body.firstChild) // add the alert in first position;
                // Hide the loading spinner;
                spinner.classList.add('d-none');
                TitleBtn.textContent = 'login';
                btnLogin.disabled = false;
            });
    }
}

function clear() {
    document.getElementById('name').value = "";
    document.getElementById('password').value = "";
}