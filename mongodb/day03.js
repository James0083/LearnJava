use mydb
db

//replaceOne({조건},{교체할데이터},{upsert:true})
//updateOne(), updateMany(), update()
db.member.find()

//db.member.updateMany({조건},{$set:{수정할 데이터}})
db.member.updateMany({age:{$lt:22}},{$set:{grade:'A'}})
//update member set grade='A' where age<22;
/*
--도큐먼트 수정 연산자--------------------------------
$set : field값 설정
$inc : field값을 증가시키거나 감소시킴
$inc:{age:2} <= age값을 본래 값에서 2만큼 증가
$mul: 곱한 값으로 수정
$rename: 필드명을 새이름으로 변경한다
$min: 필드의 값이 주어진 값보다 클 경우 새 값으로 교체합니다. 
     만약 원래 값이 200이었고 $min의 값이 150이었다면 150으로 바뀝니다. 
     기존 기록을 경신하는 경우 사용됩니다.
$max: 필드의 값이 주어진 값보다 작을 경우 새 값으로 교체합니다. 
만약 원래 값이 800이었고 $max의 값이 950이라면, 950으로 바뀝니다. 
$currentDate: 해당 필드 값을 현재 날짜로 교체합니다. 
두 가지 타입의 현재 날짜가 있는데 하나는 기본적으로 쓰이는 Date이고 
다른 하나는 Timestamp입니다. 기본 타입을 사용하려면 그냥 true하면 되고, 
timestamp 타입을 사용하려면 $type 연산자를 사용해야 합니다.
{ $currentDate: { 필드: true } }
{ $currentDate: { 필드: { $type: 'timestamp' } } }
$unset
해당 필드를 제거합니다. 만약 배열의 요소를 $unset한 경우에는 제거하진 않고 null로 교체합니다.
$setOnInsert
$set과 비슷한데 upsert의 경우에만 작동합니다. 만약 upsert가 일어나지 않으면 아무 동작도 하지 않습니다.
--------------------------------------------------------------
*/
//성적 'A'인 회원의 나이를 1증가 시키세요
//{조건}{$inc:{}}
db.member.find()
db.member.updateMany({grade:'A'},{$inc:{age:1}})
db.member.updateMany({grade:'A'},{$inc:{age:-1}})

//아이디가 'hong'인 회원의 나이에 2를 곱하세요
db.member.updateMany({userid:'hong'},{$mul:{age:2}})

//아이디가 'hong'회원의 나이가 20세보다 크면 20세로 수정하세요 =>$min
db.member.update({userid:'hong'},{$min:{age:20}})
//20세보다 클때만 수정된다.
db.member.update({userid:'hong2'},{$min:{age:20}})
//==> 이경우는 수정되지 않음 20세 미만의 값이므로

//아이디가 hong인 회원의 나이가 30세보다 작으면 30세로 수정하세요
db.member.update({userid:'hong'},{$max:{age:30}})
db.member.find()

db.member.update({userid:'hong2'},{$max:{age:10}})

//tel 필드명을 phone으로 변경하세요
//$rename
db.member.updateMany({},{$rename:{'tel':'phone'}})
db.member.find()

//모든 회원에 indate라는 필드를 추가하고 현재날짜값이 들어가도록 하세요
db.member.updateMany({},{$currentDate:{indate:true}})

//indate필드를 삭제하세요  $unset
db.member.updateMany({},{$unset:{indate:""}})

//#배열 수정
db.inventory.find()
/*
# ---배열수정 연산자------------
$addToSet: 배열필드에 해당 요소가 없으면 추가하고 있으면 아무것도 하지 않습니다. 
	몽고DB에서 자체적으로 배열에 해당 요소가 있는지 검사해주기 때문에 편합니다.
	{ $addToSet: { 필드1: 값, 필드2: 값, ... } }

$pop
배열 메소드처럼 몽고DB 배열에서 맨 앞 또는 맨 뒤 요소를 꺼내는 겁니다. 
shift와 pop을 합쳐놓은 연산자입니다. -1 값은 shift 기능, 1 값은 pop 기능을 합니다.
	{ $pop: { 필드1: ±1, 필드2: ±1, ... } }

$pull
배열에서 조건을 만족하는 특정한 요소 하나를 제거한다. 꺼내는 조건은 쿼리 연산자와 같습니다.
{ $pull: { 조건1, 조건2, ... } }
$pullAll
$pull 연산자와는 달리 $pullAll은 조건이 아니라 그냥 일치하는 값을 배열에서 꺼냅니다.
{ $pullAll: { 필드: [값1, 값2, ...] } }
$push
배열 필드에 값을 push합니다. 
{ $push: { 필드1: 값, 필드2: 값, ... } }
조심해야할 것은 값이 배열일 경우 한 번에 push해버립니다. 
만약 원래 [1, 2]라는 배열이 있다면 [3, 4, 5]를 push할 경우 [1, 2, [3, 4, 5]]가 되어버립니다. 
3, 4, 5를 따로따로 push하고 싶다면
{ $push: { 필드: { $each: 배열 } } }
해야 합니다.

$each
방금 위에서도 사용되었습니다. 다른 용례로 $addToSet과 같이 사용하는 경우가 있습니다. 
$addToSet도 $push처럼 한 번에 배열을 집어넣기 때문에 따로따로 넣고 싶다면
{ $addToSet: { 필드: { $each: 배열 } } }
해야 합니다.
-----------------------------------------
*/

//$addToSet
db.inventory.find({item:'planner'})
db.inventory.updateMany({item:'planner'},{$addToSet:{tags:'yellow'}})

db.inventory.find({item:'planner'})

//$pop : 1이 뒤를 삭제(pop), -1이면 앞을 삭제(shift)
//planner아이템의 tags 중 제일 뒤의 요소를 삭제하세요

db.inventory.updateMany({item:'planner'},{$pop:{tags:1}})
db.inventory.updateMany({item:'planner'},{$pop:{tags:-1}})
db.inventory.find({item:'planner'})

//$push
//blank추가하기
db.inventory.updateMany({item:'planner'},{$push:{tags:'blank'}})
db.inventory.find({item:'planner'})
db.inventory.updateMany({item:'planner'},{$push:{tags:['yellow','blue']}})
//=>push할때 배열을 넣으면 배열이 중첩되어 추가된다

db.inventory.updateMany({item:'planner'},{$pop:{tags:1}})
db.inventory.updateMany({item:'planner'},{$push:{tags:{$each:['yellow','blue']}}})
//=>배열의 요소값들을 push하고자 하면 $each를 이용해야 함 
db.inventory.find({item:'planner'})

//pull : 조건값으로 제거
db.inventory.updateMany({item:'planner'},{$pull:{tags:'yellow'}})
db.inventory.find({item:'planner'})
//$pullAll : 여러개를 제거할때 사용
db.inventory.updateMany({item:'planner'},{$pullAll:{tags:['blank','blue']}})
//실습------------------------------------------------------
use boardDB
db
show collections
db.board.find()
db.article.find()

db.article.drop()
db.board.drop()

db.createCollection('board')
db.createCollection('article')
db

show collections

fid=db.board.insertOne({name:'자유게시판'}).insertedId
fid

res=db.board.insertOne({name:'공지게시판'})
nid=res.insertedId
nid

db.board.find()

//article에 자유게시판에 글2개 쓰기
//         공지사항에 글1개 쓰기
//bid,title,content,writer
db.article.insertMany([
{bid:fid,title:'첫번째 글',content:'안녕하세요?',writer:'kim'},
{bid:fid,title:'두번째 글',content:'반갑습니다!',writer:'hong'}
])

db.article.insertOne({bid:nid, title:'오늘의 공지',content:'공지합니다',writer:'admin'})
db.article.find()
/*
1. boardDB에서 작업한다
2. 자유게시판에 아무 글이나 2~3개 작성한다. 특히 그 중에 글 하나에는 댓글 하나가 달린 상태로 생성해본다.
    comments:[
        { content:'1댓글입니다', writer:'noname'},
        { content:'2댓글입니다', writer:'noname2'}
    ]
3. 새로운 댓글을 이미 달린 댓글에 추가해본다

4. 비밀게시판을 생성한다.
5. 비밀게시판에 작성자가 'noname'값을 가지는 글을 하나 작성한다.
6. 모든 글에 추천수 필드(upvote)를 추가하고 값을 0으로 설정한다
7. 비밀게시판 글에 추천수를 1 증가시킨다
8. 이미 댓글이 달린 자유게시판 글에 upvote 필드 없이 댓글을 추가한다.
9. 이미 댓글이 달린 글에 방금 달은 댓글에(특징을 기억해서 수정하자) upvote 필드 값을 0으로 추가한다
==>배열요소값 수정 arraysFilters 파라미터 사용해보기.
*/
db.article.insertOne({bid:fid,title:'반갑습니다~',content:'정말 반가워요~',writer:'asdf',
                        comments:[{ content:'저도 반가워요', writer:'reple'}]})
db.article.find({bid:fid})

db.article.updateMany({bid:fid,writer:'asdf'},{$addToSet:{comments:{content:'답변글이에요',writer:'aaa'}}})
db.article.find({bid:fid})

db.article.updateMany({bid:fid,writer:'asdf'},{$push:{comments:{content:'환영합니다',writer:'admin'}}})

//마지막쓴글의 comments의 제일 마지막 댓글을 삭제하세요
db.article.updateMany({bid:fid,writer:'asdf'},{$pop:{comments:1}})
db.article.find({bid:fid})
//마지막쓴글에 comments추가하된 2개의 댓글을 한꺼번에 추가하세요
db.article.updateMany({bid:fid,writer:'asdf'},
{$addToSet:{comments:{$each:[
    {content:'환영합니다',writer:'welcome'},
    {content:'저도 정말 반가워요',writer:'metoo'}
    ]}}})

db.article.find({bid:fid})

//4. 비밀게시판을 생성한다.
db.board.insertOne({name:'비밀게시판'})

sid=db.board.find({name:'비밀게시판'}).toArray()[0]._id

sid
//5. 비밀게시판에 작성자가 'noname'값을 가지는 글을 하나 작성한다.
db.article.insertOne({bid:sid,title:'Top Secret',cotent:'비밀이에요',writer:'noname'})
db.article.find()
db.article.updateOne({bid:sid},{$unset:{cotent:""}})
db.article.updateOne({bid:sid},{$set:{content:"비밀이에요!!"}})

//6. 모든 글에 추천수 필드(upvote)를 추가하고 값을 0으로 설정한다
db.article.updateMany({},{$set:{upvote:0}})
db.article.find()

//7. 비밀게시판 글에 추천수를 1 증가시킨다
db.article.updateMany({bid:sid},{$inc:{upvote:1}})
db.article.find({})



use mydb
db
db.inventory.find({item:'notebook'})
//tags 요소중 blank를 blue로 변경해보자
//배열 요소의 일부를 수정하는 것은 어려움
//updateMany({조건},{수정연산자와데이터},{arrayFilters:[{식별자:값}]})


note_id=db.inventory.find({item:'notebook'}).toArray()[1]._id
note_id
db.inventory.updateMany({_id:note_id},{$set:{'tags.$[tagElem]':'blue'}},{arrayFilters:[{tagElem:'blank'}]})
//tagElem 식별자는 변수처럼 이름을 맘대로 지어주면 된다

//8. 이미 댓글이 달린 자유게시판 글에 upvote 필드 없이 댓글을 추가한다.
use boardDB
db
fid
db.article.updateOne({bid:fid,writer:'asdf'},{$push:{comments:{writer:'홍길동',content:'좋은 오후 되세요'}}})
db.article.find({bid:fid})

//9. 이미 댓글이 달린 글에 방금 달은 댓글에(특징을 기억해서 수정하자) upvote 필드 값을 0으로 추가한다
//==>배열요소값 수정 arraysFilters 파라미터 사용해보기.
db.article.updateMany({bid:fid,writer:'asdf'},
    {$set:{'comments.$[cmmtElem].upvote':0}},
    {arrayFilters:[{'cmmtElem.writer':'홍길동'}]}
    )
db.article.find({bid:fid})

//# 삭제: deleteOne(), deleteMany(), delete()
//deleteMany({}) : 모든 글 삭제
//drop()
//deleteMany({조건})
use mydb
db
db.member.find()
//member에서 나이가 25세를 초과하는 회원정보를 삭제하세요
db.member.deleteMany({age:{$gt:25}})
use boardDB
/*
1. 게시판의 모든 글을 삭제하시오
2. 모든 게시판을 삭제하시오
3. boardDB 데이터베이스를 삭제하시오.
*/
db.article.deleteMany({})
db.article.find()
show collections
db.article.drop()

db.board.drop()
show collections
db
db.dropDatabase()
show dbs
//-------------------------------
//집계 함수: count()
use mydb
db.member.find().count()
db.emp.find().count()
db.emp.find({deptno:20}).count()
/*
# 도큐먼트를 집계하는 방법은 3가지가 있다
[1] db의 모든 정보를 가져와 애플리케이션 단계에서 집계하는 방법
[2] 몽고디비의 맵리듀스 기능을 이용하는 방법
[3] 몽고디비의 집계 파이프라인 기능을 이용하는 방법
- 이 중에 파이프라인기능을 이용하는 방법이 처리 속도도 빠르고 램메모리 소요도 적게쓴다. 
   다만 자유도는 나쁜 편(주어진 연산자로만 가져오는데 때로 원하는 결과를 얻지 못할 수 있음)
- 집계 명령은 수많은 데이터를 처리해서 작은 양의 정보를 애플리케이션에 전달하는 특징이 있다.
  정보를 최대한 작게 만든후 앱으로 작아진 정보를 전송하는 것이 더 효율적임
- 많은양의 정보를 몽고디비 내부에서 처리한다면 많은 양의 램메모리가 필요하지 않게된다.
- 집계 파이프라인 명령어는 도큐먼트를 순차적으로 받아서 집계 처리를 몽고디비 내부에서 한다.
  맵리듀스 방식은 자바스크립트 엔진과 정보교환을 위해 램을 사용하는데 이때 대량의 메모리가 필요하게 된다.
  집계 파이프라인을 사용하는 것이 가장 합리적으로 보이지만,
  하지만 상황에 따라 맵리듀스로 처리해야 한다던지 애플리케이션에서 집계처리해야 할때도 있다.
*/
/*
집계 파이프라인 명령어 aggregation
$project : select절
$match : where절, having절
$group : group by절
$sort : order by절
$limit
$unwind
*/
db.member.aggregate([{$project:{name:1, age:1}}])

