const urlRoadmaps = 'http://localhost:8080/roadmaps';

const divRoadmap = document.querySelector('.divDashboard');

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
	window.location.href = `http://localhost:8080/trilha/adm?=${id}`
}

const addItemIntoDashboard = async () => {
	const roadmaps = await getRoadmaps(urlRoadmaps);

	const roadmapTemplate = roadmaps.map((item, index) => `
		<div class="col-12 col-md-3 bg-black-evolution p-4 mt-2">
			<div class="d-flex align-items-center justify-content-center col-12">
				<div>
					<img src="images/roadmap_image_${index+1}.svg" alt="Imagem da trilha">
				</div>
			</div>
			<div class="mt-3">
				<p class="subtitle-dark text-white">${item.title} <br><br></p>
			</div>                   
			<div class="d-flex flex-wrap justify-content-end text-end">
				<div class="col-12">
					<button type="button" class="btn-evolution-teal btn-evolution-text px-md-5" data-bs-toggle="modal" data-bs-target="#exampleModal">Novo Conteudo</button>
				</div>
				<div class="col-12 mt-3">
					<a href="trilhas_adm.html">
						<button type="button" class="btn-evolution-outline-purple btn-evolution-text px-md-5" value="${index+1}" onclick={redirectButton(${item.id})}>Editar</button>
					</a>
				</div>
			</div>
		</div>
  `).join("");
  divRoadmap.innerHTML += roadmapTemplate;
};

addItemIntoDashboard();