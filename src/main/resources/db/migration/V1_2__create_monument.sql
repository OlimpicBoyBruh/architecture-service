create table monument
(id integer not null,
creator_monument_id bigint,
date_created timestamp(6),
expert_monument_id bigint unique,
regioncode bigint,
description varchar(255),
type varchar(255) check (type in ('MEMORIAL_STONE','CROSS','BUST','STATUE','EQUESTRIAN_STATUE','TRIUMPHS_ARCH','OBELISK','ROSTRAL_COLUMN','TRIUMPHS_COLUMN','TROPHIES','CENOTAPH','ABSTRACT_COMPOSITION','MEMORIAL_SIGN','PLAQUE','TECHNICAL_MONUMENTS','MEMORIAL_COMPLEXES','PYRAMIDS')),
primary key (id))