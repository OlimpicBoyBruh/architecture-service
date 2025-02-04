create table monument_expert_evaluation (
rating integer,
 evaluation_date timestamp(6),
  id bigint not null,
   condition_description varchar(255),
    evaluator_name varchar(255),
     monument_name varchar(255),
      recommendations varchar(255),
       primary key (id))