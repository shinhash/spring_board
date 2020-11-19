
/* 에러방지용 테이블 조회 쿼리 */



/* DELETE users; */
TRUNCATE TABLE FILE_TABLE;
TRUNCATE TABLE REPLE_TABLE;
TRUNCATE TABLE BOARD_TABLE;

alter table BOARD_KIND disable constraint XPKBOARD_KIND cascade;
TRUNCATE TABLE BOARD_KIND;
alter table BOARD_KIND enable constraint XPKBOARD_KIND;


alter table USERS disable constraint XPKUSERS cascade;
TRUNCATE TABLE USERS;
alter table USERS enable constraint XPKUSERS;


/* 시퀀스 = B_SEQ, BK_SEQ, F_SEQ, GN_SEQ, R_SEQ */


/* 시퀀스 삭제 */
DROP SEQUENCE B_SEQ;
DROP SEQUENCE BK_SEQ;
DROP SEQUENCE F_SEQ;
DROP SEQUENCE GN_SEQ;
DROP SEQUENCE R_SEQ;




/* 시퀀스 생성 */
CREATE SEQUENCE B_SEQ
INCREMENT BY 1
START WITH 1;


CREATE SEQUENCE BK_SEQ
INCREMENT BY 1
START WITH 1;


CREATE SEQUENCE F_SEQ
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE GN_SEQ
INCREMENT BY 1
START WITH 1;


CREATE SEQUENCE R_SEQ
INCREMENT BY 1
START WITH 1;





Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('brown','브라운','brownPass',to_date('2020/10/22','YYYY/MM/DD'),'곰',null,null,null,'D:\profile\cb3cd39d-2a90-49d0-ad6c-12f974c59f8d.png','brown.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('cony','코니','conyPass',to_date('2020/10/21','YYYY/MM/DD'),'토끼',null,null,null,'D:\profile\cony.png','cony.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sally','샐리','sallyPass',to_date('2020/10/21','YYYY/MM/DD'),'병아리',null,null,null,'D:\profile\sally.png','sally.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('james','제임스','jamesPass',to_date('2020/10/21','YYYY/MM/DD'),'사람',null,null,null,'D:\profile\james.png','james.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('moon','문','moonPass',to_date('2020/10/21','YYYY/MM/DD'),'달',null,null,null,'D:\profile\moon.png','moon.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('leonard','레너드','leonardPass',to_date('2020/10/21','YYYY/MM/DD'),'개구리',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('edward','에드워드','edwardPass',to_date('2020/10/21','YYYY/MM/DD'),'애벌레',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('jessica','제시카','jessicaPass',to_date('2020/10/21','YYYY/MM/DD'),'고양이',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('boss','보스','bossPass',to_date('2020/10/21','YYYY/MM/DD'),'사람',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('choco','초코','chocoPass',to_date('2020/10/21','YYYY/MM/DD'),'곰2',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pangyo','팡요','pangyoPass',to_date('2020/10/21','YYYY/MM/DD'),'판다',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('muzi','무지','muziPass',to_date('2020/10/21','YYYY/MM/DD'),'토끼',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('con','콘','conPass',to_date('2020/10/21','YYYY/MM/DD'),'악어',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('apeach','어피치','apeachPass',to_date('2020/10/22','YYYY/MM/DD'),'복숭아',null,null,null,'D:\profile\0ea0ac71-89cd-4907-ad05-334915a9309d.png','apeach.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ryan','라이언 ','ryanPass',to_date('2020/10/21','YYYY/MM/DD'),'사자',null,null,null,'D:\profile\ryan.png','ryan.png');



insert into BOARD_KIND(BOARD_KIND_ID,BOARD_KIND_TITLE,BOARD_KIND_STATUS,BOARD_KIND_CREATOR,BOARD_KIND_DT) values(0, 'testtitle', 'Y', 'brown', sysdate);

insert into BOARD_TABLE(BOARD_SEQ,
                        BOARD_TITLE,
                        BOARD_CONTENT,
                        BOARD_GN,
                        USERID,
                        BOARD_DATE,
                        BOARD_KIND_ID,
                        BOARD_STATUS,
                        BOARD_RN) 
values(0,'testTitle','testContent',0,'brown',sysdate,0,'Y',0);




insert into REPLE_TABLE(BOARD_SEQ,
						REPLE_SEQ,
						REPLE_CONTENT,
						REPLE_DT,
						BOARD_KIND_ID,
						REPLE_STATUS,
						USERID)
values(0,0,'repleTestContent',sysdate,0,'Y','brown');




commit;


