
SELECT * FROM TAB

INSERT INTO DEPARTMENT (DEPT_ID, DEPT_NAME, OFFICE)
VALUES('920','컴퓨터공학과','201호')


SELECT * FROM  DEPARTMENT 


INSERT INTO DEPARTMENT VALUES('920','컴퓨터공학과','201호');
INSERT INTO DEPARTMENT VALUES('923','산업공학과','207호');
INSERT INTO DEPARTMENT VALUES('925','전자공학과','308호');


UPDATE  STUDENT 

SELECT *FROM  STUDENT 

SET YEAR =YEAR +1

INSERT INTO STUDENT 
VALUES('1292001','900424*1825409','김광식','3','서울',920);

INSERT INTO STUDENT; 
VALUES('1292002','900305*1730021','김정현','3','서울',920);

INSERT INTO STUDENT; 
VALUES('1292003','900424*2308302','김현정','4','대전',920);

INSERT INTO STUDENT ;
VALUES('1292301','890902*2704012','김현정','2','대구',923);

INSERT INTO STUDENT ;
VALUES('1292303','910715*1524390','박광수','3','광주',923);

INSERT INTO STUDENT ;
VALUES('1292305','921011*1809003','김우주','4','부산',923);

INSERT INTO STUDENT ;
VALUES('1292501','900825*156390','박철수','3','대전',925);

INSERT INTO STUDENT ;
VALUES('1292502','911011*1809003','백태성','3','서울',925);

SELECT *FROM PROFESSOR;

DELETE FROM  PROFESSOR
WHERE name='김태석';


INSERT INTO PROFESSOR ;
VALUES('92001','590327*1839240','이태규','920','교수',1997);
INSERT INTO PROFESSOR ;
VALUES('92002','690702*1350026','고희석','920','부교수',2003);
INSERT INTO PROFESSOR ;
VALUES('92301','741011*2765501','최성희','923','부교수',2005);
INSERT INTO PROFESSOR ;
VALUES('92302','750728*1102458','김태석','923','교수',1999);
INSERT INTO PROFESSOR ;
VALUES('92501','620505*1200546','박철재','925','조교수',2007);
INSERT INTO PROFESSOR ;
VALUES('92502','740101*1830264','장민석','925','부교수',2005);

SELECT *FROM  COURSE 


INSERT INTO COURSE VALUES('C101','전산개론',3);
INSERT INTO  course values('C102', '자료구조', 3);
INSERT INTO course values('C103', '데이터베이스', 4);
INSERT INTO course values('C301', '운영체제', 3);
INSERT INTO course values('C302', '컴퓨터구조', 3);
INSERT INTO course values('C303', '이산수학', 4);
INSERT INTO course values('C304', '객체지향언어', 4);
INSERT INTO course values('C501', '인공지능', 3);
INSERT INTO course values('C502', '알고리즘', 2);

SELECT *FROM  CLASS

INSERT INTO class values('C101-01', 'C101', 2012, 1, 'A', '92301', '301호', 40);
INSERT INTO class values('C102-01', 'C102', 2012, 1, 'A', '92001', '209호', 30);
INSERT INTO class values('C103-01', 'C103', 2012, 1, 'A', '92501', '208호', 30);
INSERT INTO class values('C103-02', 'C103', 2012, 1, 'B', '92301', '301호', 30);
INSERT INTO class values('C501-01', 'C501', 2012, 1, 'A', '92501', '103호', 45);
INSERT INTO class values('C501-02', 'C501', 2012, 1, 'B', '92502', '204호', 25);
INSERT INTO class values('C301-01', 'C301', 2012, 2, 'A', '92502', '301호', 30);
INSERT INTO class values('C302-01', 'C302', 2012, 2, 'A', '92501', '209호', 45);
INSERT INTO class values('C502-01', 'C502', 2012, 2, 'A', '92001', '209호', 30);
INSERT INTO class values('C502-02', 'C502', 2012, 2, 'B', '92301', '103호', 26);

SELECT  * FROM  TAKES  

INSERT INTO takes values('1292001', 'C101-01', 'B+');
INSERT INTO takes values('1292001', 'C103-01', 'A+');
INSERT INTO takes values('1292001', 'C301-01', 'A');
INSERT INTO takes values('1292002', 'C102-01', 'A');
INSERT INTO takes values('1292002', 'C103-01', 'B+');
INSERT INTO takes values('1292002', 'C502-01', 'C+');
INSERT INTO takes values('1292003', 'C103-02', 'B');
INSERT INTO takes values('1292003', 'C501-02', 'A+');
INSERT INTO takes values('1292301', 'C102-01', 'C+');
INSERT INTO takes values('1292303', 'C102-01', 'C');
INSERT INTO takes values('1292303', 'C103-02', 'B+');
INSERT INTO takes values('1292303', 'C501-01', 'A+');


SELECT  * FROM  emp;

SELECT * FROM  DEPARTMENT ,STUDENT s;

SELECT *
FROM  STUDENT S1,STUDENT S2
WHERE  S1.ADDRESS =S2.ADDRESS 
AND S1.NAME ='김광식'

SELECT  NAME,ADDRESS
FROM STUDENT 
WHERE ADDRESS='서울'

SELECT  address
FROM STUDENT s
WHERE NAME ='김광식'

SELECT  s.name,d.dept_name
FROM STUDENT s ,DEPARTMENT d 
WHERE s.DEPT_ID =d.DEPT_ID 

SELECT  name,stu_id
FROM STUDENT s
WHERE  YEAR=3 OR YEAR =4
ORDER  BY name DESC, stu_id


SELECT NAME,POSITION ,2023-YEAR_emp
FROM PROFESSOR 


SELECT *
FROM  STUDENT 
WHERE resident_id LIKE'%*2%' 
OR resident_id LIKE '%*4'

SELECT name FROM STUDENT 
union
SELECT name FROM PROFESSOR 

SELECT *FROM CLASS 

SELECT * FROM  TAKES 

SELECT * FROM  COURSE 

SELECT s.stu_id 
FROM STUDENT s , DEPARTMENT d ,TAKES t 
WHERE  s.DEPT_ID =d.DEPT_ID AND 
T.STU_ID =S.STU_ID AND 
dept_name='컴퓨터공학과'AND grade ='A+'

SELECT  stu_id
FROM STUDENT s ,DEPARTMENT d 
WHERE s.DEPT_ID =d.DEPT_ID  AND DEPT_name='컴퓨터공학과'
INTERSECT 
SELECT STU_ID 
FROM TAKES 
WHERE  grade='A+';

SELECT * FROM TAKES


SELECT stu_id FROM STUDENT s ,DEPARTMENT d 
WHERE s.DEPT_ID =d.DEPT_ID  AND dept_name='산업공학과'
MINUS 
SELECT stu_id 
FROM TAKES 
WHERE grade ='A+'

SELECT  title,credit,YEAR,semester
FROM COURSE,CLASS 
WHERE course.COURSE_ID =class.COURSE_ID 


SELECT  title,credit,YEAR,semester
FROM COURSE LEFT OUTER JOIN CLASS 
USING(COURSE_id)

SELECT title,credit,YEAR,semester
FROM COURSE RIGHT OUTER JOIN CLASS c 
USING (COURSE_id)



SELECT *FROM  EMP 
ORDER BY SAL DESC 



SELECT count(*)
FROM STUDENT 
WHERE  YEAR=3



SELECT count (MGR)
FROM  EMP 


SELECT COUNT(DEPT_ID)
FROM STUDENT 


SELECT COUNT(*)
FROM STUDENT s ,DEPARTMENT d 
WHERE S.DEPT_ID =D.DEPT_ID AND D.DEPT_NAME ='컴퓨터공학과'


SELECT COUNT(*)
FROM EMP 
WHERE JOB='SALESMAN'
AND SAL>=1500

SELECT  SUM(2012-YEAR_EMP)
FROM PROFESSOR 

SELECT SUM(SAL) 
FROM EMP
WHERE JOB='SALESMAN'

SELECT SUM(SAL)
FROM DEPT,EMP 
WHERE DEPT.DEPTNO =EMP.DEPTNO 
AND DNAME='RESEARCH'

SELECT *
FROM EMP 


SELECT AVG(SAL)--10375
FROM EMP 
WHERE job='CLERK'

SELECT AVG(SAL)--1400
FROM EMP 
WHERE job='SALESMAN'

SELECT AVG(SAL)--2758.333333333333333333333333333333333333
FROM EMP 
WHERE job='MANAGER' --


SELECT  AVG(SAL)
FROM EMP 
WHERE JOB='PRESIDENT'--5000

SELECT  AVG(SAL)
FROM EMP 
WHERE  JOB='ANALYST'--3000




SELECT  DNAME,COUNT(*),AVG(SAL), MAX(SAL),MIN(SAL)
FROM EMP E, DEPT D
WHERE E.DEPTNO =D.DEPTNO 
GROUP BY DNAME

SELECT  DEPT_NAME, COUNT(*), AVG(2012-YEAR_EMP),MAX(2012-YEAR_EMP)
FROM PROFESSOR p ,DEPARTMENT d 
WHERE P.DEPT_ID =D.DEPT_ID 
GROUP BY DEPT_NAME

SELECT MAX(SAL),AVG(SAL),MIN(SAL)
FROM EMP E,DEPT D
WHERE E.DEPTNO =D.DEPTNO  AND DNAME='ACCOUNTING'

SELECT DEPT_ID,COUNT(*)
FROM STUDENT 
GROUP BY DEPT_ID


SELECT  DEPT_NAME,COUNT(*)
FROM STUDENT s , DEPARTMENT d 
WHERE S.DEPT_ID =D.DEPT_ID 
GROUP BY DEPT_ID 


select 	dept_name, count(*), avg(2012 - year_emp), max(2012 - year_emp)
from 	professor p, department d
where 	p.dept_id = d.dept_id and avg(2012 - year_emp) >= 10
group by 	dept_name


select 	dname, count(*), avg(sal), max(sal), min(sal)
from 	emp e, dept d
where 	e.deptno = d.deptno
group by 	dname
having 	count(*) >= 5

SELECT *
FROM EMP 
WHERE COMM IS NOT NULL

SELECT  * 
FROM  TAKES 
WHERE GRADE<> 'A+'


SELECT *
FROM  EMP 
WHERE COMM<>1400


SELECT *
FROM  CLASS 
WHERE  CLASSROOM ='301호'


select 	title
from 	course
where 	course_id in 
			(select 	distinct course_id 
		 	 from 	class 
			 where 	classroom = '301호')
		
			 
select 	distinct 	title
from 	course c1, class c2
where 	c1.course_id = c2.course_id and 
		classroom = '301호'
		
SELECT  TITLE
FROM COURSE 
WHERE COURSE_ID NOT IN
(SELECT DISTINCT COURSE_ID
FROM CLASS
WHERE YEAR =2012 AND SEMESTER=2)

create or replace view 	v_takes 	as
select stu_id, class_id
from takes


SELECT* FROM  V_TAKES 
