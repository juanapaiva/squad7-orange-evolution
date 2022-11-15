let roadmapId = (window.location.search).charAt(2)

const urlRoadmap = `http://localhost:8080/roadmaps/${roadmapId}`;

const roadmapDescription = document.querySelector('.roadmapDescription');
const contentCategories = document.querySelector('.contentCategories');

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
};

addItemIntoRoadmap();