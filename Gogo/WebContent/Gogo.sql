DROP TABLE MEMBERS CASCADE CONSTRAINTS;
CREATE TABLE members
(
	mem_id varchar2(15) PRIMARY KEY,
	mem_pwd varchar2(20) NOT NULL,
	mem_name varchar2(20) NOT NULL,
	mem_phone varchar2(15) NOT NULL,
	mem_email varchar2(30) NOT NULL,
	mem_addr varchar2(200) NOT NULL,
	mem_bday date,
	mem_stat number(2,0) NOT NULL
);

DROP TABLE CATE CASCADE CONSTRAINTS;
CREATE TABLE cate
(
	cate_num number(7,0) PRIMARY KEY,
	cate_name varchar2(20) NOT NULL UNIQUE
);
insert into cate values(0, 'clothing');
insert into cate values(1, 'food');
insert into cate values(2, 'toy');
insert into cate values(3, 'etc');
insert into cate values(4, 'community');
commit;

DROP TABLE MENU CASCADE CONSTRAINTS;
CREATE TABLE menu
(
	menu_num number(7,0) PRIMARY KEY,
	menu_name varchar2(20) NOT NULL,
	cate_num number(7,0) REFERENCES CATE(CATE_NUM)
);
insert into menu values(0, 'clothing', 0);
insert into menu values(1, '사료', 1);
insert into menu values(2, '간식', 1);
insert into menu values(3, '낚싯대', 2);
insert into menu values(4, '터널', 2);
insert into menu values(5, '인형', 2);
insert into menu values(6, '모래', 3);
insert into menu values(7, '정수기', 3);
insert into menu values(8, '스크래쳐', 3);
insert into menu values(9, '공지', 4);
insert into menu values(10, '문의', 4);
insert into menu values(11, '후기', 4);
commit;

DROP TABLE PRODUCT CASCADE CONSTRAINTS;
CREATE TABLE product
(
	prod_num number(7,0) PRIMARY KEY,
	menu_num number(7,0) REFERENCES MENU(MENU_NUM),
	prod_name varchar2(50) NOT NULL,
	prod_price number(7,0) NOT NULL,
    prod_stat number(2,0) default(0)
);

DROP TABLE OP CASCADE CONSTRAINTS;
CREATE TABLE op
(
	op_num number(2,0) PRIMARY KEY,
	prod_num number(7,0) REFERENCES PRODUCT(PROD_NUM),
	op_name varchar2(20)
);

DROP TABLE DETAILOP CASCADE CONSTRAINTS;
CREATE TABLE detailOp
(
	detailOp_num number(2,0) PRIMARY KEY,
	op_num number(2,0) REFERENCES OP(OP_NUM),
    detailOp_price number(7) default(0),
	detailOp_name varchar2(20) NOT NULL
);

DROP TABLE IMAGE CASCADE CONSTRAINTS;
CREATE TABLE image
(
	img_num number(7,0) PRIMARY KEY,
	img_type number(2,0) NOT NULL,
	img_orgImg varchar2(30) NOT NULL,
	img_saveImg varchar2(30) NOT NULL,
	menu_num number(7,0) REFERENCES MENU(MENU_NUM),
	img_bnum number(7,0) NOT NULL
);

DROP TABLE BASKET CASCADE CONSTRAINTS;
CREATE TABLE basket
(
	basket_num number(7,0) PRIMARY KEY,
	mem_id varchar2(15) REFERENCES MEMBERS(MEM_ID),
	prod_num number(7,0) REFERENCES PRODUCT(PROD_NUM),
    op_num number(2,0),
    detailOp_num number(2,0),
	basket_cnt number(7,0) NOT NULL
);

DROP TABLE buy CASCADE CONSTRAINTS;
CREATE TABLE buy
(
	buy_num number(7,0) PRIMARY KEY,
	mem_id varchar2(15) REFERENCES MEMBERS(MEM_ID),
	buy_addr varchar2(300),
	buy_bdate date NOT NULL
);

drop table detailBuy cascade constraints;
create table detailBuy
(
    detailBuy_num number(7,0) primary key,
    buy_num number(7,0) references buy(buy_num),
    prod_num number(7,0) references product(prod_num),
    op_num number(2,0) references op(op_num),
    detailOp_num number(2,0) references detailOp(detailOp_num),
    detailBuy_cnt number(7,0),
    detailBuy_review number(2,0) default(0)
);

DROP TABLE PAY CASCADE CONSTRAINTS;
CREATE TABLE pay
(
	pay_num number(7,0) PRIMARY KEY,
	buy_num number(7,0) REFERENCES buy(buy_NUM),
	pay_how varchar2(20) NOT NULL,
	pay_sum number(7,0) NOT NULL,
	pay_date date NOT NULL,
	pay_stat number(2,0) default(0)
);

DROP TABLE INTER CASCADE CONSTRAINTS;
CREATE TABLE inter
(
	inter_num number(7,0) PRIMARY KEY,
	mem_id varchar2(15) REFERENCES MEMBERS(MEM_ID),
	prod_num number(7,0) REFERENCES PRODUCT(PROD_NUM)
);

DROP TABLE NOTICE CASCADE CONSTRAINTS;
CREATE TABLE notice
(
	notice_num number(7,0) PRIMARY KEY,
	notice_title varchar2(200) NOT NULL,
	notice_content varchar2(2000) NOT NULL,
	notice_wdate date NOT NULL,
	notice_step number(2,0) NOT NULL,
	notice_cate varchar2(20) NOT NULL,
	notice_hit number(7,0) NOT NULL
);

DROP TABLE QNA CASCADE CONSTRAINTS;
CREATE TABLE qna
(
	qna_num number(7,0) PRIMARY KEY,
	mem_id varchar2(15) REFERENCES MEMBERS(MEM_ID),
	qna_cate varchar2(20) NOT NULL,
	qna_title varchar2(200) NOT NULL,
	qna_content varchar2(2000) NOT NULL,
	qna_pwd number(7,0) NOT NULL,
	qna_wdate date NOT NULL,
	qna_ref number(7,0) NOT NULL,
	qna_level number(2,0) NOT NULL,
	qna_step number(2,0) NOT NULL
);

DROP TABLE REVIEW CASCADE CONSTRAINTS;
CREATE TABLE review
(
	review_num number(7,0) PRIMARY KEY,
	mem_id varchar2(15) REFERENCES MEMBERS(MEM_ID),
	detailBuy_num number(7,0) REFERENCES detailBuy(detailBuy_num),
	review_title varchar2(200) NOT NULL,
	review_content varchar2(2000),
	review_star number(2,0) NOT NULL,
	review_wdate date NOT NULL,
	review_like number(7,0) NOT NULL
);

DROP TABLE freedom CASCADE CONSTRAINTS;
CREATE TABLE freedom
(
	freedom_num number(7,0) PRIMARY KEY,
	freedom_title varchar2(200) NOT NULL,
	freedom_content varchar2(2000) NOT NULL,
	freedom_wdate date NOT NULL,
	freedom_hit number(7,0) NOT NULL
);