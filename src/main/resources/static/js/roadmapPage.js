let roadmapId = (window.location.search).charAt(2)

const urlRoadmap = `http://localhost:8080/roadmaps/${roadmapId}`;

const roadmapDescription = document.querySelector('.roadmapDescription');
const contentCategories = document.querySelector('.contentCategories');
const contentBox = document.querySelector('.contentBox');
const categoryName = document.querySelector('.categoryName');

let categories = []

const getRoadmap = async (urlItem) => {
  try {
    const response = await fetch(urlItem);
    return response.json();
  } catch (error) {
    return response;
  }
};

const addItemIntoRoadmap = async () => {
  const roadmap = await getRoadmap(urlRoadmap);

  const roadmapDescriptionTemplate = `              
			<p class="heading-2">${roadmap.title}</p>
			<p class="body-copy">Tempo estimado: ${roadmap.duration} horas</p>
			<p class="body-copy">Trilha montada por: ${roadmap.creator}</p>
  `;
  roadmapDescription.innerHTML += roadmapDescriptionTemplate;

  roadmap.contents.forEach(item => {
    categories.push(`${item.category}`);
  });
  categories = [...new Set(categories)]

  const contentCategoriesTemplate = categories.map((item) => `
    <div class="d-flex align-items-center justify-content-between col-12">
      <div>
        <a class="body-bold">${item}</a>
      </div>          
      <div>
        <img src="../images/check-off.svg" alt="">
      </div>
    </div>
  `).join("");
  contentCategories.innerHTML += contentCategoriesTemplate;

  const contentBoxTemplate = roadmap.contents.map((item) => `
  <div class="col-12 categoryName"></div>

  <div class="d-flex flex-wrap col-12 justify-content-end">  
    <p class="small-copy me-2">Filtrar</p>        
    <div>
      <img src="../images/filter-icon.svg" alt="">
    </div>
  </div>

  <div class="d-flex flex-wrap col-12 justify-content-end text-center mt-2 contentTypes">          
    <div class="tag-dark me-2">
      <p>TYPE</p>
    </div>          
    <div class="tag-dark me-2">
      <p>TYPE</p>
    </div>          
    <div class="tag-dark me-2">
      <p>TYPE</p>
    </div>          
    <div class="tag-dark me-2">
      <p>TYPE</p>
    </div>          
    <div class="tag-dark">
      <p>TYPE</p>
    </div>
  </div>

  <div class="col-12 p-4 mt-2 mb-2 bg-black-evolution contentInfos">
    <div>
      <p class="body-bold text-white">TITLE</p>
    </div>
    <div class="d-md-flex align-items-baseline mt-2">          
      <p class="body-bold text-white me-md-3">OWNER</p>
      <p class="body-copy me-md-3">DURATION</p>          
      <div class="tag-white text-center me-md-3">
        <p>TYPE</p>
      </div>
    </div>

    <div class="mt-3">
      <p class="body-copy text-white">SUBJECT</p>
    </div>
    <div class="d-md-flex justify-content-end text-center mt-3">
      <div class="me-0 me-md-2">
        <button type="button" class="btn-evolution-outline-purple btn-evolution-text px-md-5">ACESSAR</button> <!-- LINK -->
      </div>
      <div class="mt-3 mt-md-0">
        <button type="button" class="btn-evolution-teal btn-evolution-text px-md-5" data-bs-toggle="modal" data-bs-target="#exampleModal">CONCLUÍDO</button>
      </div>
    </div>
  </div>


  <div class="col-12 p-4 mb-2 bg-black-evolution">
    <div>
      <p class="body-bold text-white">TITLE</p>
    </div>
    <div class="d-md-flex align-items-baseline mt-2">          
      <p class="body-bold text-white me-md-3">OWNER</p>
      <p class="body-copy me-md-3">DURATION</p>          
      <div class="tag-white text-center me-md-3">
        <p>TYPE</p>
      </div>
    </div>

    <div class="mt-3">
        <p class="body-copy text-white">SUBJECT</p>
    </div> 
    <div class="d-md-flex justify-content-end text-center mt-3">
      <div class="me-0 me-md-2">
        <button type="button" class="btn-evolution-outline-purple btn-evolution-text px-md-5">ACESSAR</button>
      </div>
      <div class="mt-3 mt-md-0">
        <button type="button" class="btn-evolution-teal btn-evolution-text px-md-5" data-bs-toggle="modal" data-bs-target="#exampleModal">CONCLUÍDO</button>
      </div>
    </div>
  </div>

  <div class="col-12 p-4 mb-2 bg-black-evolution">
    <div>
      <p class="body-bold text-white">TITLE</p>
    </div>
    <div class="d-md-flex align-items-baseline mt-2">          
      <p class="body-bold text-white me-md-3">OWNER</p>
      <p class="body-copy me-md-3">DURATION</p>          
      <div class="tag-white text-center me-md-3">
        <p>TYPE</p>
      </div>
    </div>

    <div class="mt-3">
      <p class="body-copy text-white">SUBJECT</p>
    </div> 
    <div class="d-md-flex justify-content-end text-center mt-3">
      <div class="me-0 me-md-2">
        <button type="button" class="btn-evolution-outline-purple btn-evolution-text px-md-5">ACESSAR</button>
      </div>
      <div class="mt-3 mt-md-0">
        <button type="button" class="btn-evolution-teal btn-evolution-text px-md-5" data-bs-toggle="modal" data-bs-target="#exampleModal">CONCLUÍDO</button>
      </div>
    </div>
  </div>
  `).join("");
  contentBox.innerHTML += contentBoxTemplate;

  const categoryNameTemplate = categories.map((item) => `
    <p class="subtitle-dark">Teste${item}</p>
  `).join("");
  categoryName.innerHTML += categoryNameTemplate;
};

addItemIntoRoadmap();