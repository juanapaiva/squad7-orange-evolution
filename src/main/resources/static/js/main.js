const urlUser = 'http://localhost:8080/users/4'; // retornar o id do user após login
const urlRoadmaps = 'http://localhost:8080/roadmaps';

const userName = document.querySelector('.userName');
const userProfile = document.querySelector('.userProfile');
const userInterests = document.querySelector('.userInterests');
const divRoadmap = document.querySelector('.divDashboard');

let user = [];
let roadmap = [];

const getRoadmaps = async (urlItem) => {
  try {
    const response = await fetch(urlItem);
    return response.json();
  } catch (error) {
    return response;
  }
};

// Redirecionamento das trilhas
function redirectButton(id) {
	window.location.href = `http://localhost:8080/roadmaps/${id}`
}

const addItemIntoDashboard = async () => {
	const user = await getRoadmaps(urlUser);
  const roadmaps = await getRoadmaps(urlRoadmaps);

	const userNameTemplate = `<p class="h1">Bem-vinde ao Orange Evolution, ${user.name}</p>`;
  userName.innerHTML += userNameTemplate;

	const userProfileTemplate = `              
		<p class="h3">${user.name}</p>
		<p class="h5">${user.email}</p>
  `;
  userProfile.innerHTML += userProfileTemplate;

	const userInterestsTemplate = user.interests.map((item) => `
		<div class="me-2">
			<p>${item.stack}</p>
		</div>
  `).join("");
  userInterests.innerHTML += userInterestsTemplate;

  const roadmapTemplate = roadmaps.map((item, index) => `              
      <div class="border p-4 mt-2">
  	  	<div class="d-flex align-items-center justify-content-center col-12">
	        <div>
	          <img src="images/roadmap_image_${index+1}.svg" alt="Imagem da trilha">
	        </div>
  		</div>
		  
  		<div>		
    		<p class="h5">${item.title}</p>
  		</div>
		  
  		<div class="d-md-flex justify-content-end text-end">	
	        <div class="me-0 me-md-2">
	          <button type="button" class="btn btn-dark" value="${index+1}" onClick={redirectButton(${item.id})}>ACESSAR</button>
	        </div>
	  	</div>
	 </div>
  `).join("");
  divRoadmap.innerHTML += roadmapTemplate;
};

addItemIntoDashboard();