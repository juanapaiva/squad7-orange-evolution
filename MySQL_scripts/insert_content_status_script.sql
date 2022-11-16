insert into tb_content_status (id, user_id, roadmap_id, content_id, status_id)
select null, 2, id_roadmap, id, 1
from tb_contents;

insert into tb_content_status (id, user_id, roadmap_id, content_id, status_id)
select null, 3, id_roadmap, id, 1
from tb_contents;

insert into tb_content_status (id, user_id, roadmap_id, content_id, status_id)
select null, 4, id_roadmap, id, 1
from tb_contents;