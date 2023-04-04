
1. 데이터베이스와 DBMS(Datatbase Management System)란?

- 기업이 지속적으로 유지관리 해야 할 데이터의
 집합(Database)
- 방대한 양의 데이터를 편리하게 관리하고
효율적으로 저장하고 검색할 수 있는 환경을
제공해 주는 시스템 소프트웨어(DBMS)를 말한다

☞ 무결성(Integrity)
	-데이터베이스에 저장된 데이터 값과 그것이 표현하는 현실 세계의
	  실제 값이 일치하는 정확성을 의미한다.
	  **무결성 제약조건=> 데이터베이스에 저장된 데이터의 정확성을
		보장하기 위해 정확하지 않은 데이터가 
		데이터베이스 내에 저장되는
		것을 방지하기 위한 제약조건을 의미
	1> NULL 무결성: 특정 속성 값이 NULL이 될 수 없도록 하는 규정
	2> UNIQUE 무결성: 특정 속성에 대해 각 튜플이 갖는 속성값들이
			서로 달라야 한다.
	3> Domain 무결성: 특정 속성 값이 그 속성이 정의된 도메인에 속한
			값이어야 한다.
			ex] 성별 속성에는 '남' 또는 '여' 값만 존재해야 한다.
	4> Relation 무결성 : 관계에 대한 적절성 여부를 지정한 규정
	5> 참조(Referential) 무결성: 외래키 값은 null이거나 참조 릴레이션의
			기본키(PK)와 동일해야 한다는 규정
	6> 개체 무결성	: 기본 릴레이션의 기본키(PK)를 구성하는 어떤
			속성도 null일 수 없다는 규정.

[실습] 학생 테이블을 만들어 전반적인 sql문을 간략하게 실습해보자

토드 다운로드
http://www.toadworld.com/m/freeware/default.aspx?Redirected=true
에서
Toad for Oracle Freeware v12.5 (64-bit) 를 다운로드하자.

sql로 오라클과 통신할 수 있는 응용 프로그램

2. 데이터의 검색

# SQL문장 작성법
	1. 대소문자를 구분하지 않는다. (literal값은 대소문자 구분한다)
	2. 한줄 또는 여러 줄 입력 가능
	3. 하나의 명령어는 여러줄에 나누거나 단축될 수 없다.
	4. 일반적으로 키워드는 대문자로 입력, 
	  다른 모든 단어는 소문자로 입력(권장)
	5. SQL*PLUS에서 SQL문장은 라인 번호가 붙으며,
	   가장 최근의 명령어가 SQL BUFFER에 저장된다.
	   (sql명령어만 PLUS명령어는 안들어감)
# SQL문장의 실행
	1. 마지막 절 끝에 ; 을 기술하여 명령의 끝을 표시한다.
		-버퍼 편집시에는 ;는 안쓰고 대신 / 를 쓴다.
	2. 버퍼에서 마지막 라인에 / 를 넣는다.

# SELECT문(자료 조회)의 형식
	1> SELECT 컬럼명1, 컬럼명2, .... FROM 테이블명
	2> SELECT * FROM 테이블명
		.. 전체 컬럼을 모두 선택하려면 * 를 입력하면 됨.
	
	cf> 테이블명 뒤에 다음의 문장을 추가하면 더 
	      자세한 자료를 추출할 수 있다.
	      - WHERE : 검색하려는 자료에 조건을 주어 필요한
			      정보만을 뽑을 수 있다.
	     - GROUP BY: 일정한 형식을 지닌 자료를 그룹화
				하는 경우에 사용
	     - BETWEEN : 얻은 결과에서 레코드 순번으로
				필요한 자료만큼만 읽을 때 사용
	     - ORDER BY: 얻은 결과를 정렬할 때 사용

[실습]
모든 열의 선택
SELECT * FROM EMP;

특정 컬럼 선택
SELECT EMPNO,ENAME FROM EMP;
-> 실행결과 날짜,문자열은 좌측 정렬, 숫자는 우측 정렬됨

산술 표현식
SELECT ENAME, SAL, SAL+300 FROM EMP;
SELECT EMPNO,ENAME,SAL,COMM,SAL+COMM FROM EMP
select ename,sal,sal*1.1 from emp


#NULL값의 처리

NULL이란?-행의 특정 컬럼에 대해 데이터 값이 없을 경우 
		이를 NULL이라고 한다.
		NULL값은 이용할 수 없거나 지정되지 않았거나, 
		알 수 없거나 또는 적용할 수 없는 값이다.
		0이나 공백과는 다름. 0은 숫자, 공백은 문자임
		컬럼이 생성될 때 NOT NULL로 지정되지 않았거나
		PRIMARY KEY로 정의되지 않았다면 어떤 컬럼은
		NULL값을 포함 할 수 있다.
		예] EMP테이블의 COMM 컬럼의 경우

		SELECT EMPNO,ENAME, COMM FROM EMP;

#NVL함수

	1) NVL 함수는 NULL 값을 다른 값으로 바꿀 때 사용.
	2)  모든 데이터 타입에 적용이 가능하다.	
	3) 이 함수를 사용할 때는 전환되는 값의 자료형을 
	   일치 시켜야 한다.

	아래 두 문장의 차이를 살펴보세요.

	SELECT ENAME,SAL,SAL*12+COMM FROM EMP
	SELECT ENAME,SAL,COMM, SAL*12+NVL(COMM,0)

# NVL2 함수
	1) 자바의 삼항 연산자와 비슷
	2) NVL2(expr, expr1, expr2)
	3) expr의 값이 NULL이 아닐 경우에는 expr1의 값을 반환 하고, 
	NULL일 경우에는 expr2의 값을 반환 한다.

	--사원 테이블에서 관리자(MGR)이 있는 경우는 1, 없으면 0을
	 출력하시오
	 select empno,ename, mgr, nvl2(mgr,1,0) MGR2 from emp

# 컬럼에 별칭(ALIAS) 부여
	1) 컬럼 제목 이름을 변경한다.
	2) 컬럼 바로 뒤에 사용한다. 컬럼명과 별칭 사이에 AS를 넣기도 함
	3) 공백이나 특수문자 또는 대소문자를 구분하기 원하면
	   이중부호("")가 필요하다.

	   SELECT ENAME AS NAME, SAL SALARY,
	   SAL*12+NVL(COMM,0) BONUS FROM EMP

# LITERAL 문자열
	컬럼명이나 별칭이 아닌 SELECT목록에 포함되어 있는 문자, 표현식,숫자
	를 의미.
	날짜와 문자열의 경우 단일 인용부호('')를 사용해야 한다.

	SELECT ENAME||' '|| 'IS A'||' '||JOB 
	AS "EMPLOYEES DETAILS" FROM EMP
	
	문제] EMP테이블에서 이름과 연봉을 "KING: 1 YEAR SALARY = 60000"
	형식으로 출력하라.

	SELECT ENAME||' : 1 YEAR SALARY='||SAL*12 "사원의 연봉"
	FROM EMP

#DISTINCT -중복행의 제거
	- 주로 하나의 컬럼에서 중복된 값을 제외하고 보여줄 때 사용한다.
	- SELECT DISTINCT 컬럼명 FROM 테이블

	EMP테이블에서 업무(JOB)를 모두 출력하세요.
		SELECT JOB FROM EMP;
	EMP테이블에서 담당하고 있는 업무의 종류를 출력하세요/
		SELECT DISTINCT JOB FROM EMP;

	부서별로 담당하는 업무를 한번씩 출력하세요.
		SELECT DISTINCT DEPTNO, JOB FROM EMP;

	- DISTINCT라는 키워드는 항상 SELECT 바로 다음에서 기술한다.
	- DISTINCT뒤에 나타나는 컬럼들은 모두 DISTINCT의 영향를 받는다.
	- DISTINCT뒤에 여러 개의 컬럼이 기술되면 나타나는 행은 컬럼의
	  조합들이 중복되지 않게 나타난다.

	(즉 , DISTINCT 혹은 UNIQUE를 사용한 결과로 Unique한 데이터를
	검색한다는 것은 DISTINCT 뒤의 한 칼럼에만 적용되는 것이 아니라
	출력되는 행 전체에 대해 Unique 하게 검색된다는 의미입니다.)
	  ex] select distinct name, job from member;
	        select unique name, job from member;

 	-DISTINCT를 사용하면 나타나는 결과는 기본적으로 오름차순 
	 정렬됨
	 [문제]
	 1] EMP테이블에서 중복되지 않는 부서번호를 출력하세요.
	 2] MEMBER테이블에서 회원의 이름과 나이 직업을 보여주세요.
	 3] CATEGORY 테이블에 저장된 모든 내용을 보여주세요.
	 4] MEMBER테이블에서 회원의 이름과 적립된 마일리지를 보여주되,
	      마일리지에 13을 곱한 결과를 "MILE_UP"이라는 별칭으로
	      함께 보여주세요.


//////////////////////////////////////////////////////////////////////////////////
3. 데이터 제한과 정렬

# 특정 행의 검색
	모든 자료를 가져오는 것이 아니라 사용자가 원하는 자료만
	조회하고자 한다면 WHERE절을 사용한다.
	WHERE 절은 조건절을 포함하여 FROM절 다음에 기술 한다.

	[실습]
	EMP테이블에서 급여가 3000 이상인 사원의 사원번호,이름,
	담당업무,급여를 출력하세요.	
	SELECT EMPNO,ENAME,JOB,SAL FROM EMP 
	WHERE SAL >=3000

	EMP테이블에서 담당업무가 MANAGER인 사원의
	정보를 사원번호,이름,업무,급여,부서번호로 출력하세요.
	SELECT EMPNO,ENAME,JOB,SAL,DEPTNO
	FROM EMP WHERE JOB='MANAGER'

	EMP테이블에서 1982년 1월1일 이후에 입사한 사원의 
	사원번호,성명,업무,급여,입사일자를 출력하세요.
	SELECT EMPNO,ENAME,JOB,SAL,HIREDATE
	FROM EMP WHERE HIREDATE > '82/01/01'

	[참고]
	-문자 string과 날짜 값은 ' '를 사용한다.
	-문자값은 대소 문자를 구분한다.
	-날짜값은 날짜 형식을 구분한다.

#SQL연산자
- WHERE  조건절에서 자료를 검색할 때 조건을 달기 위해 사용하는 구문.

	1) =		: 같은가?	 WHERE name='홍길동'
	2)<		: 작은가?	WHERE age < 30
	3) <=	: 작거나 같은가
	4) >		: 큰가?
	5)>=		: 크거나 같은가?
	6)<>		: 같지 않은가?  != 과 같은 의미. 
			  where name <> '홍길동' -> 이름이 홍길동이 아닌 데이터
	7)!=		: 같지 않은가?  <>과 같은 의미.
	8)like	: 값의 일부를 이용하여 데이터의 정보와 일치하는지를 묻는 연산자.
			  where name like '%길%'  -> 이름 중 '길' 자를 포함된 
			  데이터가 있는지 검색.
	9) BETWEEN a AND b : a와 b 사이에 있는가(a,b값 포함)
				- 작은 값을 앞에 기술하고 큰 값을 뒤에 기술해야 함
	10) IN (list) : list값 중 어느 하나와 일치하는가
	11) NOT BETWEEN a AND b : a와 b사이에 있지 않다.(a,b값 포함하지 않음)
	12) NOT IN (list) : list값과 일치하지 않는가.

	[실습]
	emp테이블에서 급여가 1300에서 1500사이의 사원의 이름,업무,급여,
	부서번호를 출력하세요.
	select ename,job,sal,deptno from emp
	where sal between 1300 and 1500;

	select ename,job,sal,deptno from emp
	where sal >=1300 and sal<=1500;

	emp테이블에서 사원번호가 7902,7788,7566인 사원의 사원번호,
	이름,업무,급여,입사일자를 출력하세요.
	select empno,ename,job,sal,hiredate
	from emp where empno in (7902,7788,7566)

	select empno,ename,job,sal,hiredate
	from emp where empno =7902 or empno=7788
	or empno=7566;

	10번 부서가 아닌 사원의 이름,업무,부서번호를 출력하세요
	SELECT ENAME,JOB,DEPTNO FROM EMP
	 WHERE NOT DEPTNO=10 ORDER BY DEPTNO ASC;

	 SELECT ENAME,JOB,DEPTNO FROM EMP
	 WHERE DEPTNO <> 10 ORDER BY 3 ASC;
	[문제]
	emp테이블에서 업무가 SALESMAN 이거나 PRESIDENT인
	사원의 사원번호,이름,업무,급여를 출력하세요.
	
	커미션(COMM)이 300이거나 500이거나 1400인 사원정보를 출력하세요
	
	커미션이 300,500,1400이 아닌 사원의 정보를 출력하세요



# LIKE연산자

	검색 문자열값에 대한 와일드 카드 검색을 위해 사용

	  where name like '%길%'  -> 이름 중 '길' 자를 포함된 데이터가 있는지 검색.
	'%'는 문자가 없거나 하나 이상의 문자를(0개 이상의 문자)
	'_'는 하나의 문자와 대치된다.(1개의 문자)

	- WHERE 컬럼명 LIKE '조건'
	- WHERE 컬럼명 LIKE '%조건'
	- WHERE 컬럼명 LIKE '조건%'
	- WHERE 컬럼명 LIKE '%조건%'
	[실습]
	- EMP테이블에서 이름이 S로 시작되는 사람의 정보를 보여주세요.
	SELECT * FROM EMP WHERE ENAME LIKE 'S%'

	-이름 중 S자가 들어가는 사람의 정보를 보여주세요.
	SELECT * FROM EMP WHERE ENAME LIKE '%S%'
	
	- 이름의 두번 째에 O자가 들어가는 사람의 정보를 보여주세요.
	SELECT * FROM EMP WHERE ENAME LIKE '_O%'
	

	[문제]

	- EMP테이블에서 입사일자가 82년도에 입사한 사원의 사번,이름,업무
	   입사일자를 출력하세요.	 

	[참고] --------------------------------------
	기본 날짜 형식이 'YY-MM-DD'인 경위 위와 같이
	그러나 아래와 같이 형식이 바뀐다면 검색은 달라져야 함.
	
	ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD'; <=시스템날짜 형식 변경
	ALTER SESSION SET NLS_DATE_FORMAT='DD-MON-YYYY';
	SELECT HIREDATE FROM EMP;	

	[문제]
	
	- 고객 테이블 가운데 성이 김씨인 사람의 정보를 보여주세요.
	select name, age, job from member where name like '김%';
	- 고객 테이블 가운데 '강남구'가 포함된 정보를 보여주세요.
	select name, addr from member where addr like '%강남구%';

	- 카테고리 테이블 가운데 category_code가 0000로 끝는 상품정보를 보여주세요.
	select * from category where category_code like '%0000';


# IS NULL연산자

	- NULL값 여부를 체크 하고자 할 때
	  (NULL: 값이 없거나, 알 수 없거나 적용할 수 없단 의미)

	  IS NULL과 IS NOT NULL 구문을 이용하여 NULL을 비교한다.
		.. NULL일 경우		: WHERE 컬럼이름 IS NULL
		.. NOT NULL일 경우	: WHERE 컬럼이름 IS NOT NULL
	[실습]
	SELECT EMPNO,ENAME COMM FROM EMP WHERE COMM IS NULL
	
	-주의: NULL값은 EQUAL(=)비교가 안됨.
		 IS NULL로 비교해야 함
		 SELECT EMPNO,ENAME COMM FROM EMP WHERE COMM = NULL;[X]

	- 반면 일반적인 문자 값을 비교할 경우
		.. 같을 경우		: WHERE 컬럼 이름 = 비교값
		.. 다를 경우		: WHERE 컬럼 이름 <> 비교값, 
					또는 WHERE 컬럼 이름 != 비교값


# 논리 연산자
	1) AND : 양쪽 조건이 TRUE이면 TRUE를 반환
	2) OR  : 양쪽 조건 중 하나라도 TRUE이면 TRUE반환
	3) NOT : 이후의 조건이 FALSE이면 TRUE를 반환.
	
	[실습]
	- EMP테이블에서 급여가 1100이상이고 JOB이 MANAGER인 사원의
	사번,이름,업무,급여를 출력하세요.
	SELECT EMPNO,ENAME,JOB,SAL
	FROM EMP WHERE SAL >=1100 AND JOB='MANAGER'

	- EMP테이블에서 급여가 1100이상이거나 JOB이 MANAGER인 사원의
	사번,이름,업무,급여를 출력하세요.
	SELECT EMPNO,ENAME,JOB,SAL
	FROM EMP WHERE SAL >=1100 OR JOB='MANAGER'
	
	- EMP테이블에서 JOB이 MANAGER,CLERK,ANALYST가 아닌
	  사원의 사번,이름,업무,급여를 출력하세요.
	SELECT EMPNO,ENAME,JOB,SAL
	FROM EMP WHERE JOB NOT IN ('MANAGER','CLERK','ANALYST')


	[문제]
	- EMP테이블에서 급여가 1000이상 1500이하가 아닌 사원의


   - EMP테이블에서 이름에 'S'자가 들어가지 않은 사람의 이름을 모두
	  출력하세요.

	- 사원테이블에서 업무가 PRESIDENT이고 급여가 1500이상이거나
	   업무가 SALESMAN인 사원의 사번,이름,업무,급여를 출력하세요.


	- 고객 테이블에서 이름이 홍길동이면서 직업이 학생이 정보를 
	    모두 보여주세요.

	- 고객 테이블에서 이름이 홍길동이거나 직업이 학생이 정보를 
	모두 보여주세요.

	- 상품 테이블에서 제조사가 S사 또는 D사이면서 
	   판매가가 100만원 미만의 상품 목록을 보여주세요.

	
	*참고). 연산자간 우선순위
	   모든 비교 연산자 > NOT > AND > OR(오른쪽으로 갈수록 우선순위가 낮다.)

# ORDER BY 절

	- 자료를 정렬하여 나타낼 때 필요한 구문.
	- 오름차순 ASC
	- 내림차순 DESC 
	  두 가지 방식이 있다.
	- ORDER BY절을 사용할 때는 SELECT구문의 가장 마지막에 위치

	만약 사용자가 데이터가 나타나는 순서를 지정하지 않으면 
	기본적으로 데이터는 테이블에 입력되어 있는 순서대로 표시되지만, 
	같은 SELELCT문에 대하여 Oracle Server에서 처음의 검색결과와 다음의 
	검색결과를 항상 똑같이 보여주는 것은 아니다. 
	따라서 사용자가 검색한 데이터를 특정순서로 지정하여보고 싶으면 
	ORDER BY절을기술하여야 한다. 

	NULL값은 오름차순에서 제일 나중에, 내림차순에선 제일 먼저 옴

	[실습]
	사원테이블에서 입사일자 순으로 정렬하여 사번,이름,업무,급여,
	입사일자를 출력하세요.
	SELECT EMPNO,ENAME,JOB,SAL,HIREDATE
	FROM EMP ORDER BY HIREDATE

	최근 입사한 순으로 사번,이름,업무,급여,입사일자를 출력하세요.
	SELECT EMPNO,ENAME,JOB,SAL,HIREDATE
	FROM EMP ORDER BY HIREDATE DESC

	-- 다양한 정렬방법-------------------------------
	SELECT EMPNO,ENAME,JOB,SAL,SAL*12 ANNSAL
	FROM EMP ORDER BY ANNSAL

	SELECT EMPNO,ENAME,JOB,SAL,SAL*12 ANNSAL
	FROM EMP ORDER BY SAL*12
	
	SELECT EMPNO,ENAME,JOB,SAL,SAL*12 ANNSAL
	FROM EMP ORDER BY 5
	-------------------------------------------------
	
	사원 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우
	급여가 많은 순으로 정렬하여 사번,이름,업무,부서번호,급여를
	출력하세요.
	SELECT DEPTNO,SAL,EMPNO,ENAME,JOB
	FROM EMP ORDER BY DEPTNO, SAL DESC

	사원 테이블에서 첫번째 정렬은 부서번호로, 두번째 정렬은
	업무로, 세번째 정렬은 급여가 많은 순으로 정렬하여
	사번,이름,입사일자,부서번호,업무,급여를 출력하세요.
	SELECT DEPTNO,JOB,SAL EMPNO,ENAME,HIREDATE
	FROM EMP ORDER BY DEPTNO, JOB, SAL DESC

	
	[문제]
	

	1] 상품 테이블에서 판매 가격이 저렴한 순서대로 상품을 정렬해서 
	    보여주세요.
		select * from products  order by output_price asc;

	2] 고객 테이블의 정보를 이름의 가나다 순으로 정렬해서 보여주세요.
	      단, 이름이 같을 경우에는 나이가 많은 순서대로 보여주세요.
		select * from member order by name asc, age desc;

		..정렬된 자료를 다시 한번 정렬하는 내용임.

	 3] 고객 테이블에서 직업의 종류와 각 직업에 속한 사람의 수가 
	     많은 순서대로 보여주세요.
		select job, count(*) from member group by job
		order by count(*) desc;

	 4]	상품테이블에서 공급업체별로 평균판매가를 구하되 
		평균판매가 오름차순으로 보여주세요.
		select ep_code_fk, round(avg(output_price),2)from products 
		group by ep_code_fk 
		order by avg(output_price) asc;

	 5] 상품 테이블에서 배송비의 내림차순으로 정렬하되, 
	    같은 배송비가 있는 경우에는
		마일리지의 내림차순으로 정렬하여 보여주세요.
		1) select products_name, trans_cost, mileage from products 
		    order by trans_cost desc, mileage desc;

		또는
		2) select products_name, trans_cost, mileage from products 
		    order by 2 desc, 3 desc;

		두 번째 구문은 컬럼명 대신 컬럼의 순서를 입력하여 정렬하는 것을 보여주고 있다.

 [종합문제]
	1] 사원테이블에서 급여가 3000이상인 사원의 정보를 모두 출력하세요.
		SELECT * FROM EMP WHERE SAL >=3000
	2] 사원테이블에서 사번이 7788인 사원의 이름과 부서번호를 출력하세요
		SELECT ENAME,EMPNO FROM EMP WHERE EMPNO=7788
	3] 사원테이블이서 입사일이 1981 2월20일 ~ 1981 5월1일 사이에
	    입사한 사원의 이름,업무 입사일을 출력하되, 입사일 순으로 출력하세요.
		SELECT TO_CHAR(HIREDATE,'YY-MM-DD') H_DATE, ENAME,JOB
		FROM EMP WHERE TO_CHAR(HIREDATE,'YY-MM-DD') >'81-02-20'
		AND TO_CHAR(HIREDATE,'YY-MM-DD') < '81-05-01' ORDER BY H_DATE

	4] 사원테이블에서 부서번호가 10,20인 사원의 이름,부서번호,업무를 출력하되
	    이름 순으로 정렬하시오.
	    SELECT ENAME,DEPTNO,JOB FROM EMP 
	    WHERE DEPTNO IN (10,20) ORDER BY ENAME
	
	5] 사원테이블에서 1982년에 입사한 사원의 모든 정보를 출력하세요.
	6] 사원테이블에서 보너스가 급여보다 10%가 많은 사원의 이름,급여,보너스
	    를 출력하세요.
	    SELECT ENAME,SAL,COMM FROM EMP
		WHERE COMM >= SAL*1.1
	7] 사원테이블에서 업무가 CLERK이거나 ANALYST이고
	     급여가 1000,3000,5000이 아닌 모든 사원의 정보를 
	     출력하세요.
	     SELECT ENAME,JOB,SAL FROM EMP
		WHERE JOB IN ('CLERK','ANALYST') AND
		SAL NOT IN (1000,3000,5000)

	8] 사원테이블에서 이름에 L이 두자가 있고 부서가 30이거나
	    또는 관리자가 7782번인 사원의 정보를 출력하세요.
		SELECT ENAME,DEPTNO,MGR FROM EMP
		WHERE ENAME LIKE '%LL%' AND DEPTNO =30 OR MGR=7782


///////////////////////////////////////////////////////////////////////////////////
4. SQL 함수

#함수의 특징 및 이점
1) 데이터에 연산을 수행할 수 있다.
2) 개별적인 데이터 항목을 수정할 수 있다.
3) 행의 그룹에 대해 결과를 조작할 수 있다.
4) 출력을 위한 날짜와 숫자형식을 조절할 수 있다.
5) 열의 자료형을 변환할 수 있다.

# 함수 종류
1) 단일행 함수
2) 그룹 함수
3) 기타 함수

# 단일행 함수######################################################
- 단일 행에 대해서만 적용 가능하고 행별로 하나의 결과를 반환한다.
	CF> 그룹 함수
	- 단일행 함수와 달리 그룹함수는 여러 행 또는 테이블 전체에 대해
	  함수가 적용되어 하나의 결과를 가져오는 함수를 말한다.


  함수명 (컬럼|표현식[arg1,arg2....])

- 단일행 함수 종류
	1) 문자형 함수: 문자를 입력받고 문자와 숫자 모두를 반환할 수 있다.
	2) 숫자형 함수: 숫자를 입력받고 숫자를 반환한다.
	3) 날짜형 함수: 날짜형에 대해 수행하고 숫자를 반환하는 MONTHS_BETWEEN
			 함수를 제외하고 모두 날짜 데이터형의 값을 반환한다.
	4) 변환형 함수: 어떤 데이터형의 값을 다른 데이터형으로 변환한다.
	5) 일반적인 함수: NVL, DECODE

- 단일행 함수의 특징
	1) 질의에서 반환되는 각각의 행에 대해 수행
	2) 행별로 하나의 결과를 반환
	3) 참조시 사용한 데이터형과 다른 데이터형으로 결과를 반환할 수 있다.
	4) 하나 이상의 인수를 필요로 한다.
	5) SELECT,WHERE,ORDER BY 절에서 사용할 수 있다.
	6) 함수를 중첩할 수 있다.
		단일행 함수들은 여러 레벨에 걸쳐 중첩사용이 가능하다.
		중첩된 함수들은 가장 하위 레벨에서 가장 상위 레벨 
		순으로 진행된다.

1. 문자형 함수
------------------------------------------------------
종류			함수			사용목적
------------------------------------------------------
변환함수	 LOWER		알파벳을 소문자로 변환
			UPPER		알파벳을 대문자로...
			INITCAP		첫번째 글자만 대문자로 변환
------------------------------------------------------
문자조작함수	CONCAT		두 문자열을 연결
			SUBSTR		문자열 중 특정 문자 또는 문자열의
						일부분을 선택
			LENGTH		문자열의 길이를 구함
			LPAD			왼쪽 문자 자리채움
			RPAD			오른쪽 문자 자리 채움
			LTRIM			왼쪽 문자를 자름
			RTRIM			오른쪽 문자를 자름
			REPLACE		특정 문자열을 대신
------------------------------------------------------
LOWER/UPPER 
	-LOWER는 대문자를 소문자로, UPPER는 소문자를 대문자로 
	 바꿔서 출력하는 함수

	     select lower('HAPPY BIRTHDAY') from daul;==>happy birthday
	     select upper('happy birthday') from daul;==>HAPPY BIRTHDAY

	[잠깐!] **dual테이블은 무엇?*****************************************
	 연산이나 날짜 등에 대한 정보를 보기 위해 사용하는 테이블
	 한개의 행으로 구성되어 있다.
	 가령 2*4의 결과를 알고 싶다면...
	 select 2*4 from dual;

	만약 select 2*4 from student; 한다면 학생테이블이 갖는 행의 수만큼 결과가 나옴
	그러나 dual로 하면 한개의 행만 있으므로 동일 결과를 한개의 행으로만 볼 수 있음
	 *******************************************************************


     [문제] 사원 테이블에서 SCOTT의 사번,이름,담당업무(소문자로),부서번호를
		출력하세요.
		

		사원테이블에서 이름이 'scott'인 사람의 정보를 출력하세요.
		
INITCAP
	-첫 문자를 대문자로 나머지는 소문자로 변환
		DEPT테이블에서 컬럼의 첫 글자들만 대문자로 변환하여 모든
		정보를 출력하라.
		SELECT DEPTNO,INITCAP(DNAME),INITCAP(LOC) FROM DEPT;

CONCAT
	- 두 개 이상의 문자나 컬럼을 서로 연결시켜 주는 함수
	   가령 우편번호와 주소 컬럼이 따로 떨어져 있다면 CONCAT 함수를 이용하여 하나의
	   컬럼처럼 사용할 수 있다.
	- CONCAT(변수1, 변수2)
	- 결과값: 변수1과 변수2를 연결한 값을 리턴. 단 변수1과 변수2에 
	             숫자를 입력하더라도 문자로 인식하여 결합하게 된다.

	  select cocat('abcd','가나다라') from dual; ==>abcd가나다라
	  select cocat('123','456') from dual; ==>123456

	  SELECT EMPNO,ENAME,JOB,CONCAT(EMPNO,ENAME) E_NAME,
	  CONCAT(ENAME,JOB) E_JOB FROM EMP;	


	  [문제]
	 
	 상품 테이블에서 판매가를 화면에 보여줄 때 금액의 단위를 함께 
	 붙여서 출력하세요.
	 select products_name, concat(output_price,'원') price from products;
	 
	 고객테이블에서 고객 이름과 나이를 하나의 컬럼으로 만들어 결과값을 화면에
	       보여주세요.
		

SUBSTR
	- SUBSTR(변수, X, Y)
	 :문자 X로 시작한 Y개 문자 길이만큼 변수를 리턴합니다.
	 만일 X가 0이라면 1로 처리되고 X가 음수라면 문자는 끝에서 부터 
	 시작하고
	 오른쪽으로부터 세어서 리턴한다. 
	 또한 Y가 없다면 디폴트로 전체를 의미하고
	 Y가 1 이하라면 NULL이 리턴된다.
	 주민번호를 앞번호만 물러내어 정보를 알려주고 싶은 경우 사용

	  select substr('ABCDEFG',3,3) from dual ==> CDE
	  select substr('ABCDEFG',-3,3) from dual ==> EFG
	  select substr('891222-2123123',8,7) from dual ==> 2123123	
	  select substr('8912222123123',7) from dual==> -2123123
	  select substr('8912222123123',-7) from dual==> 2123123

	  [문제]
	  사원 테이블에서 첫글자가 'K'보다 크고 'Y'보다 작은 사원의
	  사번,이름,업무,급여를 출력하세요. 단 이름순으로 정렬하세요.
	
	 
LENGTH
	- 주어진 컬럼 또는 문자열의 길이를 리턴하는 함수
	- LENGTH(변수 또는 컬럼)
	- 결과값: 변수나 컬럼의 길이를 문자 단위로 리턴함.
	  만약 변수가 NULL일 경우는 NULL을 리턴

	select length('891222-2123123') from dual ==>14

	[문제]
	사원테이블에서 부서가 20번인 사원의 사번,이름,이름자릿수,
	급여,급여의 자릿수를 출력하세요.
	
	
	사원테이블의 사원이름 중 6자리 이상을 차지하는 사원의이름과 
	이름자릿수를 보여주세요.
	

LPAD/RPAD
	-문자값을 왼쪽/오른쪽부터 채운다.
	-LPAD(컬럼,변수1,변수2)

	 SELECT ENAME,LPAD(ENAME,15,'*'), SAL,LPAD(SAL,10,'*')
	 FROM EMP WHERE DEPTNO=10;

	 SELECT RPAD(DNAME,15,'*') FROM DEPT
	 

LTRIM
	-왼쪽의 공백을 제거할 때 사용
	- LTRIM(변수1, 변수2)
	- 결과값: 변수1에 넣었던 값 중에서 변수2와 같은 단어가 있을 경우, 
	       그 문자를
	      삭제한 나머지값을 리턴한다. 

	  select ltrim('tttHello test','t') from dual; ==> Hello test
	  select ltrim('   Hello test',' ') from dual; ==> Hello test
	
	[문제]
	사원테이블에서 담당업무 중 좌측에 'A'를 삭제하고
	급여중 좌측의 1을 삭제하여 출력하세요.


RTRIM
	- 오른쪽으로 부터 시작해서 값을 변경
	 select rtrim('tttHello test','t') from dual; ==> tttHello tes

	[문제]
	사원테이블에서 10번 부서의 사원에 대해 담당업무 중 우측에'T'를
	삭제하고 급여중 우측의 0을 삭제하여 출력하세요.
	

REPLACE
	- 정해진 컬럼이나 이름에서 지정한 문자를 특정 문자로 변경하는 함수
	- REPLACE(인수1, 인수2, 인수3)
	- 결과값: 인수1에 있는 값 중 인수2에 해당하는 단어를 인수3으로 변경
	  select replace('oracle test','test','hi') from dual; ==> oracle hi


	  [문제]
	  사원테이블 JOB에서 'A'를 '$'로 바꾸어 출력하세요.
	
	  	

	 고객 테이블의 직업에 해당하는 컬럼에서 직업 정보가 학생인 정보를 모두
	 대학생으로 변경해 출력되게 하세요.
	

	 고객 테이블 주소에서 서울시를 서울특별시로 수정하세요.
	 
 

 2. 숫자형 함수
 -------------------------------------------------------------
	함수				사용목적
 -------------------------------------------------------------
	 ROUND		숫자를 반올림
	 TRUNC		숫자를 절삭
	 MOD			나머지 구함
	 POWER		거듭제곱
	 SQRT		제곱근
	 SIGN			양수,음수,0인지를 구분
	 CHR			ASCII값에 해당하는 문자를 구함
	 ABS			절대값을 구함
	 CEIL			올림함수
	 FLOOR		내림함수
 -------------------------------------------------------------

ROUND
	- ROUND(값) 또는 ROUND(X,Y) : 반올림 함수. 
	-  한자리 숫자일 경우에는 반올림하고
	   두 자리 숫자일 경우에는 소수점의 오른쪽에서 Y 자리만큼 반올림된 X를
	   나타낸다. 이때 Y값이 음수와 양수에 따라 다른 결과를 보여준다.

	  SELECT ROUND(4567.678), ROUND(4567.678,0), ROUND(4567.678,2),
	  ROUND(4567.678,-2) FROM DUAL;	

	  숫자를 Y자리 만큼 반올림할 때 Y자리가 양수면 소수자리를
	  Y자리가 음수이면 정수 자리를 반올림한다.
	  생략할 경우 디폴트는 0이다.
	
	[실습]
	    select mileage,age,mileage/age,round(mileage/age) 
	    from member where mileage>0

TRUNC

	- TRUNC(값) 또는 TRUNC(X,Y) : 버림을 담당하는 함수.
	  ROUND함수와 사용방법은 같다. 
	  일정한 단위로 절사하는 경우에
	  주로 사용하는 함수. 영수증에서 10이하 단위는 잘라내고 10원 단위로
	  금액을 출력시킬때 사용

	  SELECT TRUNC(4567.678), TRUNC(4567.678,0),
	 TRUNC(4567.678,2), TRUNC(4567.678,-2) FROM DUAL
	 
	 [문제]
	 상품 테이블의 상품 정보가운데 천원단위까지 버린 배송비를 비교하여 출력하세요.
	 select products_name,trans_cost, trunc(trans_cost,-4) from products

 MOD
	- MOD(값1, 값2) : 나머지 값을 돌려주는 함수
	사원테이블에서 부서번호가 10인 사원의 급여를 
	30으로 나눈 나머지를 출력하세요.
	SELECT SAL, MOD(SAL,30) FROM EMP WHERE DEPTNO=10

 ABS(값)
	 :선택된 값의 절대값을 보여주는 함수. 
	   음수값이 있는 컬럼 값을 양수로 나타내고자 할 때 사용.
	  select name, age, age-40, abs(age-40) from member;
CEIL(값): 올림 함수	
	SELECT CEIL(123.12) FROM DUAL
FLOOR(값): 내림 함수
	SELECT FLOOR(123.12) FROM DUAL



# 날짜 함수
오러클은 세기,년,월,일,시,분,초를 내부 숫자(7BYTE)형식으로
날짜를 지정한다.

-날짜 연산
	--------------------------------------------------
	연산				결과		설명
	--------------------------------------------------
	1) DATE + NUMBER 	DATE		일수를 날짜에 더함
	2) DATE - NUMBER 	DATE		일수를 날짜에 뺌
	3) DATE - DATE						일수	
	4) DATE + NUMBER/24   	DATE		시간을 날자에 더함
	--------------------------------------------------
	[실습]
	사원테이블에서 현재까지의 근무 일수가 몇 주 몇일인가를 출력하세요.
	단 근무일수가 많은 사람순으로 출려하세요.
	
	먼저) DATE- DATE를 하면 일수가 나온다.
	SELECT HIREDATE,SYSDATE,(SYSDATE-HIREDATE) FROM EMP;

	SELECT ENAME,SYSDATE,HIREDATE,SYSDATE-HIREDATE "TOTAY DAYS",
	TRUNC((SYSDATE-HIREDATE)/7) WEEKS, 
	ROUND(MOD((SYSDATE-HIREDATE),7)) DAYS 
	FROM EMP
	ORDER BY SYSDATE-HIREDATE DESC;

	--------------------------------------------------
	함수				사용목적
	--------------------------------------------------
	MONTHS_BETWEEN	        두 날짜사이의 월수를 계산
	ADD_MONTHS		월을 날짜에 더함
	LAST_DAY		월의 마지막 날을 구함
	SYSDATE			오러클이 설치되어 있는 서버의 
					현재 날짜와 시간을 반환
	--------------------------------------------------

MONTHS_BETWEEN	
	- 날짜와 날짜 사이의 월수를 계산한다.
	- MONTHS_BETWEEN(DATE1,DATE2)
	- 결과는 음수 또는 양수가 될 수 있다.
	- 결과의 정수 부분은 월을, 소수 부분은 일을 나타낸다.

	SELECT MONTHS_BETWEEN(SYSDATE,HIREDATE) FROM EMP;


ADD_MONTHS
	- 정해진 컬럼이나 날짜형 변수에 원하는 개월을 더하고자 할 때 사용
	- ADD_MONTHS(D,X)
	- 결과값: 날짜 D에 X월 만큼 더한 날짜를 리턴한다. 여기서 X는 정수이고,
	   만약 결과값의 월이 D
	   의 월보다 날짜 수가 적다면 결과값의 월의 마지막 일이 리턴된다.

	  select add_months('08/09/11',2) from dual;==>08/11/11
	  SELECT ADD_MONTHS('08/11/11',2) FROM DUAL ==> 09/01/11
	  _
	 select add_months('08/01/31',1) from dual;==>08/02/29
	 select add_months(sysdate,-1) from dual;

	 select hiredate,add_months(hiredate,-10) from emp

	  고객 테이블이 두 달의 기간을 가진 유료 회원이라는 가정하에 등록일을 기준으로
	   유료 회원인 고객의 정보를 보여주세요.
	   select name, reg_date, add_months(reg_date,2) as expire from member;

LAST_DAY
	- 월의 마지막 날짜를 구할 대 사용하는 함수(윤년,평년은 자동으로 계산함)
	   일정 관리 프로그램이나 다이어리 등을 만들 때 1월 ~12월까지의 마지막 일자를 
	   LAST_DAY 함수를 이용하여 구하면 쉽게 달력프로그램을 만들 수 있다.
	- LAST_DAY(D)
	- 결과값: D가 포한되어 있는 월의 마지막 날짜 값을 리턴
	 select last_day('03/12/11') from dual==>03/12/31

	 사원테이블에서 입사한 달의 근무일수를 계산하여 출력하되,
	 토요일과 일요일도 근무일수에 포함하는 것으로 하자.

	select ename, hiredate, last_day(hiredate) last,
	last_day(hiredate)-hiredate days from emp
	order by days desc
	

SYSDATE
	- 현재 시간을 DATE타입으로 출력하는 함수.
	- SYSDATE
	- 결과값: 현재 로컬 데이터베이스의 날짜와 시간값을 리턴한다.
	select to_char(sysdate,'yyyy-mm-dd hh:mi:ss') from dual;
	select to_char(sysdate,'cc year-month-ddd day') from dual

	 -cc, scc : 세기
	 -yyyy, year, yyy, yy : 연도
	 -iyyy, iy, i : ISO 년을 의미
	 -month,mon, mm: 월
	 -ww, w : 주
	 -ddd, dd: 일 [ddd->1년의 날짜, dd->1개월의 날짜, d->1주일의 날짜]
	 -hh, hh24, hh12: 시간
	 -day, dy, d: 그주의 시작 일자
	 -mi : 분
	 -ss : 초

3. 변환함수

TO_CHAR(날짜)
	- 문자가 아닌 자료형의 값을 문자형으로 변환시키는 함수
	- TO_CHAR(날짜) 함수는 DATE타입을 문자로 바꾼다.
	- TO_CHAR(D, 출력형식)
	- 결과값: DATE형인 D를 출력형식에 맞는 VARCHAR2 로 변환하여 리턴.
	      출력형식이 없을 경우에는 기본이 되는 날짜형을 문자형으로 변환하여 리턴.

	  select to_char(sysdate) from dual;
	  select to_char(sysdate,'yyyy-mm-dd hh12:mi:ss') from dual;

	 고객테이블의 등록일자를 0000-00-00 의 형태로 출력하세요.
	 select name, to_char(reg_date,'yyyy-mm-dd') from member;
	 
	 고객테이블에 있는 고객 정보 중 등록연도가 2013년인 
	 고객의 정보를 보여주세요.
	 select userid,name,age, job, to_char(reg_date,'yyyy-mm-dd') as d 
	 from member where to_char(reg_date,'yyyy') = '2003';

	 고객테이블에 있는 고객 정보 중 등록일자가 2013년 5월1일보다 
	 늦은 정보를 출력하세요. 
	 단, 고객등록 정보는 년, 월만 보이도록 합니다.
	 select userid,name,age, job, to_char(reg_date,'yyyy-mm-dd') as d 
	 from member where reg_date >='2013-05-01';

TO_DATE
	- TO_CHAR(날짜)와 상반된 기능을 갖는다. 즉, 문자 데이터를 강제로 
	   날짜형 데이터로 변환시키는 것.
	   TO_CHAR(날짜)는 출력을 위해 사용하는 함수이며, 
	   TO_DATE 는
	   프로그램 내부에서 날짜를 계산하거나 비교하기 위해 
	   날짜형 데이터로 변환하는데 사용되는 함수이다.
	- TO_DATE(변수, 출력형식)
	- 결과값: CHAR나 VARCHAR2 형식의 변수를 날짜형 데이터
			DATE로 변환하여 값을 리턴
	      만일 출력형식이 없다면 세션의 기본 날짜 출력형식을 사용해야 한다.

	 68] select to_date('20080601','yyyymmdd') as d from dual;
	 69] select sysdate - to_date('20080601','YYYYMMDD') from dual;
	 ...sysdate와 문자값을 - 연산할 수 없으므로 Date타입으로 변경하여 연산하는 예제.
	 70] 고객테이블의 고객 정보 중 등록일자가 2003년 6월1일 이후 등록한 고객의 정보를
	      보여 주세요.
	 select name,reg_date from member
	 where reg_date > to_date('20030601','YYYYMMDD')

TO_CHAR(숫자)
	- TO_CHAR(X, 출력형식)
	- 결과값: 숫자형인 X를 오른쪽의 출력 형식에 맞는 varchar2로 
		     변환하여 리턴.
	 71] select to_char(10000,'99,999') from dual;
	 72] select to_char(10000,'$99G999') from dual==> $10,000
	 ...G는 지정된 위치에서 그룹 구분 문자를 리턴한다.
 ------------------------------------------------------------------------
 포맷요소		포맷된 문자		설명
 ------------------------------------------------------------------------
 9			99				각각의 9는 결과에서 유효 자리를 나타냄
							여기서 리턴되는 값은 9의 수와 같은 유효 자리
							의 수를 갖는다.
 ------------------------------------------------------------------------
 0			999				빈칸이 아니라 앞에 붙은 0을 리턴함
 ------------------------------------------------------------------------
 $			$999				통화기호와는 무관하게 앞에 달러 기호를
							가진 값을 리턴함
 ------------------------------------------------------------------------
 B			B999				정수 부분이 0일 경우 소수의 정수 부분에 대해
							빈칸을 리턴함
 ------------------------------------------------------------------------
 S			S9999			앞에 붙은 기호를 리턴함. 양수에 대해서는 "+"
							음수에 대해서는 "-"를 리턴
 ------------------------------------------------------------------------
 S			 9999S			뒤에 붙은 기호를 리턴함. 양수에 대해서는 "+"
							음수에 대해서는 "-"를 리턴
 ------------------------------------------------------------------------
 D			99D9				지정된 위치에서 소수점을 리턴함
 ------------------------------------------------------------------------
 G			9G999			지정된 위치에서 그룹 구분 문자를 리턴함
 ------------------------------------------------------------------------
 C			 C99				지정된 위치에서 ISO 통화 기호를 리턴함
 ------------------------------------------------------------------------
 L			L999				지정된 위치에서 지역 통화기호를 리턴함
 ------------------------------------------------------------------------
 EEEE			9.99EEEE			과학적 표기법을 사용하여 값을 리턴함
 ------------------------------------------------------------------------
 RM			RM				 대문자 로마 숫자를 사용하여 값을 리턴함
 ------------------------------------------------------------------------
 ,			 999,999			지정된 위치에 ","를 표시함
 ------------------------------------------------------------------------
 .			999.99			소수점 자리를 표시함
 ------------------------------------------------------------------------
	 73] 상품 테이블에서 상품의 공급 금액을 가격 표시 방법으로 표시하세요.
	  천자리 마다 , 를 표시합니다.
	  select products_name, to_char(input_price,'99,999,999') as A from products;
	 74] 상품 테이블에서 상품의 판매가를 출력하되 주화를 표시할 때 사용하는 방법을
	  사용하여 출력하세요.[예: \10,000]
	  select products_name, to_char(output_price,'L99,999,999') as A from products
 
TO_NUMBER
	-TO_CHAR와 상반되는 함수. 문자열을 숫자로 변환해주는 역할을 함
	-TO_NUMBER(변수, 출력형식)
	-결과값: CHAR나 VACHAR2 형식의 변수를 NUMBER값으로 변환함. 
	     출력 형식이
	     있는 경우에는 변수가 숫자 출력형식과 같아야 한다.
	     75] select to_number('1,234','9,999') from dual ==>1234
	     76] select to_number('$1,234','$9,999') from dual ==>1234
	     77] select to_char(-23,'999S') from dual ==> 23-
	     78] select to_char(-23,'99D99') from dual ==> -23.00
	     79] select to_char(23,'99.99') from dual ==>23.00
	     80] select to_char(23,'99.99EEEE') from dual ==>2.30E+01

4. 그룹 함수
	- 단일행 함수와 달리 그룹함수는 여러 행 또는 테이블 전체에 대해
	  함수가 적용되어 하나의 결과를 가져오는 함수를 말한다.

	- 그룹함수의 종류
		AVG( DISTINCT| ALL| N) : NULL값을 제외한 N개 행의 평균값
		COUNT(DISTINCT| ALL| expr |*) :* =>NULL값을 포함한 행의 개수
		MAX(DISTINCT| ALL|expr) : 최대값
		MIN(DISTINCT| ALL|expr)  : 최소값
		STDDEV(DISTINCT| ALL| n) : NULL값을 제외한 n의 표준편차
		SUM(DISTINCT| ALL|n) :	 NULL값을 제외한 n의 합계
		VARIANCE()		:	 NULL값을 제외한 n의 분산

		* distinct는 중복되지 않는 값만 반환한다.그러나
		* all 은 해당함수로 모든 값을 고려하게 한다.
		* expr이 있는 인수들의 자료형태는 char, varchar2, number,date
		   형이 될 수 있다.
		* count(*)를 제외한 모든 그룹함수들은 NULL값을 무시한다.
		   NULL값을 하나의 값으로 치환하기 위해서는 NVL함수를 사용한다.
		* 모든 자료형에 대해 MAX와 MIN을 사용할 수 있다.
		   그러나 AVG, SUM, VARIANCE,STDDEV는 NUMBER만 사용가능하다.

		  SELECT COUNT(MGR) FROM EMP; 
		  ==> 13개. null값을 무시하고 셈

		  SELECT COUNT(distinct MGR) from emp;
		  ==> 6개. 중복되지 않는 값만 리턴.

		  그러나 count(*) 는 null값을 인정한다.
		  select count(*) from emp;

		  ex)가령 test테이블아 아래와 같다면
		  -------------
		  a	b	c
		  -------------
		  null  null    null
		  null  null    null	
		 -------------
		 위의 경우 select count(*) from test;하면 =>2를 반환
		 그러나     select count(a) from test;하면 => 0을 반환

		 [실습]
		 emp테이블에서 모든 SALESMAN에 대하여 급여의 평균,
		 최고액,최저액,합계를 구하여 출력하세요.
		 SELECT AVG(SAL),MAX(SAL),MIN(SAL),SUM(SAL) 
		 FROM EMP WHERE JOB='SALESMAN';

		 아래 문장을 실습해보고 분석해보세요.
		 SELECT MIN(ENAME),MAX(ENAME), 
		 MIN(HIREDATE),MAX(HIREDATE),
		 MIN(SAL),MAX(SAL) FROM EMP;
		
		[문제]
		EMP테이블에 등록되어 있는 인원수, 보너스에 NULL이 아닌 인원수,
		보너스의 평균,등록되어 있는 부서의 수를 구하여 출력하세요.
////////////////////////////////////////
9. GROUP BY
- 특정 컬럼이나 값 등을 기준으로 해당 레코드를 묶어서 자료를 
   관리할 때 사용하는 구문. 그룹함수와 함께 사용.
  상품 테이블에서 각 상품군별로 몇 개의 상품이 있는지 검사하거나, 
  직업군 별로 최대, 최소값을 구할 때 사용됨.

  group by 절에 명시된 컬럼값이 같을 때 그룹을 만들고 이 그룹으로부터 집합함수를 통해 
  다양한 결과를 얻는다.

	16] 고객 테이블에서 직업의 종류와 각 직업에 속한 사람의 수를 
	     보여주시오.
		select job, count(*) from member group by job;

	cf>count는 함수. 직업별로 사람수를 파악할 때 사용.

	17] 고객 테이블에서 직업의 종류, 각 직업에 속한 최대 마일리지 정보를 보여주세요.
		select job, max(mileage) from member group by job;

	18] 상품 테이블에서 각 상품카테고리별로 총 몇 개의 상품이 있는지 보여주세요.
		select category_fk, count(*) from products group by category_fk 
		order by category_fk asc;

		또한 최대 판매가와 최소 판매가를 함께 보여주세요.
		select category_fk, count(*), max(output_price),min(output_price) 
		from products group by category_fk order by category_fk asc;

	19] 상품 테이블에서 각 공급업체 코드별로 공급한 상품의 평균입고가를 보여주세요.
		select ep_code_fk, avg(input_price) from products group by ep_code_fk;

	문제1] 사원 테이블에서 입사한 년도별로 사원 수를 보여주세요.
	

	문제2] 사원 테이블에서 해당년도 각 월별로 입사한 사원수를 보여주세요.

	문제3] 사원 테이블에서 업무별 최대 연봉, 최소 연봉을 출력하세요.

10. HAVING
- GROUP BY와 항상 함께 사용하는 구문.
   GROUP BY 의 결과에 조건을 주어 제한할 때 사용한다.

	20] 고객 테이블에서 직업의 종류와 각 직업에 속한 사람의 수가 
	     2명 이상인 직업군
	      의 정보를 보여주시오.
	      select job, count(*) from member group by job 
	      having count(*) >1;
	
	21] 고객 테이블에서 직업의 종류와 각 직업에 속한 최대 마일리지 정보를 보여주세요.
	      단, 직업군의 최대 마일리지가 0인 경우는 제외시킵시다.
	      select job, max(mileage) from member group by job having max(mileage)<>0;

	문제1] 상품 테이블에서 각 카테고리별로 상품을 묶은 경우, 해당 카테고리의 상품이 2개인 
	      상품군의 정보를 보여주세요.
	      

	문제2] 상품 테이블에서 각 공급업체 코드별로 상품 판매가의 평균값 중 단위가 100단위로 떨어
	      지는 항목의 정보를 보여주세요.


	문제3]
11. ORDER BY
- 자료를 정렬하여 나타낼 때 필요한 구문.
- 오름차순 ASC
- 내림차순 DESC 
  두 가지 방식이 있다.
- ORDER BY절을 사용할 때는 SELECT구문의 가장 마지막에 위치

만약 사용자가 데이터가 나타나는 순서를 지정하지 않으면 
기본적으로 데이터는 테이블에 입력되어 있는 순서대로 표시되지만, 
같은 SELELCT문에 대하여 Oracle Server에서 처음의 검색결과와 다음의 
검색결과를 항상 똑같이 보여주는 것은 아니다. 
따라서 사용자가 검색한 데이터를 특정순서로 지정하여보고 싶으면 
ORDER BY절을기술하여야 한다. 


	24] 상품 테이블에서 판매 가격이 저렴한 순서대로 상품을 정렬해서 
	보여주세요.
	select * from products  order by output_price asc;

	25] 고객 테이블의 정보를 이름의 가나다 순으로 정렬해서 보여주세요.
	      단, 이름이 같을 경우에는 나이가 많은 순서대로 보여주세요.
		select * from member order by name asc, age desc;

		..정렬된 자료를 다시 한번 정렬하는 내용임.

	 26] 고객 테이블에서 직업의 종류와 각 직업에 속한 사람의 수가 
	     많은 순서대로 보여주세요.
		select job, count(*) from member group by job
		order by count(*) desc;

	문제1]	상품테이블에서 공급업체별로 평균판매가를 구하되 
		평균판매가 오름차순으로 보여주세요.
		

	 문제2] 상품 테이블에서 배송비의 내림차순으로 정렬하되, 같은 배송비가 있는 경우에는
		마일리지의 내림차순으로 정렬하여 보여주세요.
