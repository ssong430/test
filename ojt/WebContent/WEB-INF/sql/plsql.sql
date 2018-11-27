DROP TABLE DEPT CASCADE CONSTRAINTS;

 
-- �μ� ���̺�
CREATE TABLE DEPT
( 
        DEPTNO NUMBER(2),
        DNAME VARCHAR2(14),
        LOC VARCHAR2(13) 
);
 
 
INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT VALUES (20, 'RESEARCH',   'DALLAS');
INSERT INTO DEPT VALUES (30, 'SALES',      'CHICAGO');
INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');
 
 
 
 
DROP TABLE EMP CASCADE CONSTRAINTS;
 
-- ���� ���̺�
CREATE TABLE EMP
(
        EMPNO     NUMBER(4) NOT NULL,
        ENAME      VARCHAR2(10),
        JOB           VARCHAR2(9),
        MGR          NUMBER(4),
        HIREDATE    DATE,
        SAL            NUMBER(7, 2),
        COMM        NUMBER(7, 2),
        DEPTNO      NUMBER(2)
);
 
 
DELETE FROM EMP;
 
 
INSERT INTO EMP VALUES(7654, 'MARTIN', 'SALESMAN',  7698,
        sysdate, 1250, 1400, 30);
INSERT INTO EMP VALUES(7698, 'BLAKE',  'MANAGER',   7839,
        sysdate,  2850, NULL, 30);
INSERT INTO EMP VALUES(7782, 'CLARK',  'MANAGER',   7839,
       sysdate,  2450, NULL, 10);
INSERT INTO EMP VALUES(7788, 'SCOTT',  'ANALYST',   7566,
        sysdate, 3000, NULL, 20);
INSERT INTO EMP VALUES(7839, 'KING',   'PRESIDENT', NULL,
        sysdate, 5000, NULL, 10);
 
 
SELECT * FROM EMP;
 
 
COMMIT;
 
 
 
 
 

 

 
 
 
SELECT * FROM emp WHERE deptno=10 ORDER BY deptno;
 


 
 
SELECT * FROM emp WHERE deptno=10 ORDER BY deptno;

SELECT * FROM emp WHERE deptno=10 ORDER BY deptno;
 
 
 

 
 
select * from emp where deptno=10 order by deptno;
 
 
 
 
 
--4. Out Parameterm�� ���
  -- - �μ���ȣ�� �Է¹޾� �������� �����մϴ�.
 
CREATE or REPLACE PROCEDURE proc2(
    i_deptno IN number, -- �μ� ��ȣ
    o_count OUT number  -- ���� ��
)
IS
BEGIN
    SELECT count(*) INTO o_count FROM EMP
    WHERE deptno = i_deptno;
END;
/
 
 
 
 
-- ������ ���
SELECT count(*) as o_count FROM EMP
WHERE deptno = 10;
 
 
 
-- Toad���� DBMS Output�� Enable �ϰ� ����
 
DECLARE
    i_deptno number :=10;
    o_count number := 0;
BEGIN
    proc2(i_deptno, o_count);
    DBMS_OUTPUT.PUT_LINE(o_count);
END;
/
 
 
 
 
