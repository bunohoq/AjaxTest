--설문조사
create table tblSurvey (
    seq number primary key,
    question varchar2(300) not null,
    item1 varchar2(100) not null,
    item2 varchar2(100) not null,
    item3 varchar2(100) not null,
    item4 varchar2(100) not null,
    cnt1 number default 0 not null,
    cnt2 number default 0 not null,
    cnt3 number default 0 not null,
    cnt4 number default 0 not null
);

create SEQUENCE seqSurvey;

insert into tblSurvey values (1, '가장 자신있는 프로그래밍 언어는?'
    , 'JAVA', 'Pyuhon', 'C#', 'Kotlin', default, default, default, default); 
    
select * from tblsurvey;

update tblSurvey set
    cnt1 = 3,
    cnt2 = 4,
    cnt3 = 10,
    cnt4 = 1;
commit;
    
-- 고양이 위치
create table tblCat (
    catid varchar2(50) primary key,     --<img id="cat1">
    x number not null,                  --left
    y number not null                   --top
);

insert into tblCat values ('cat1', 0, 0);

commit;


