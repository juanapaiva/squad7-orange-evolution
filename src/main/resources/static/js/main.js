let roadmap = [];

const divRoadmap = document.querySelector('.divDashboard');

const urlRoadmaps = 'http://localhost:8080/roadmaps';

const getRoadmaps = async () => {
  try {
    const response = await fetch(urlRoadmaps);
    return response.json();
  } catch (error) {
    return response;
  }
};

//getRoadmaps();

const addItemIntoDashboard = async () => {
  const items = await getRoadmaps();

  console.log({items})
  const itemTemplate = items.map((item, index) => `              
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
	          <button type="button" class="btn btn-dark" value="${index+1}">ACESSAR</button>
	        </div>
	  	</div>
	 </div>
  `).join("");
  
  console.log(itemTemplate)

  divRoadmap.innerHTML += itemTemplate;
};

addItemIntoDashboard();