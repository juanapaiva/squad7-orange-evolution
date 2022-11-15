let roadmapId = (window.location.search).charAt(2)

const urlRoadmap = `http://localhost:8080/roadmaps/${roadmapId}`;
const urlContent = 'http://localhost:8080/contents';

const roadmapDescription = document.querySelector('.roadmapDescription');

let content = [];

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
};

addItemIntoRoadmap();