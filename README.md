# java-chess
체스 게임 구현을 위한 저장소

# 기능 요구사항
## step 1
- [x] 체스판을 구현한다.
- [x] 게임 시작 및 종료 명령어를 입력받는다.
    - [x] 명령어는 start, end만 입력 가능하다.
- [x] 명령어가 start인 경우 게임 실행 및 체스판을 초기화한다.
- [x] 명령어가 end인 경우에는 게임을 종료한다. 

## step 2
- [x] 말을 이동한다.
  - [x] 각 말의 전략에 따라 이동한다.
    - [x] 폰은 두 가지 이동 전략을 가진다.
  - [x] 방향을 계산한다.
  - [x] 좌표를 계산한다.
- [x] 말을 이동한 뒤 보드를 업데이트한다.

## step 3
- [x] 킹을 잡으면 게임을 끝낸다.
- [x] 킹이 잡힌 팀이 진다.
- [x] status를 입력하면 각 진영의 점수를 출력한다.
- [x] status를 입력하면 각 진영의 승패 결과를 출력한다. 
- [x] 각 말은 점수를 갖는다. 
- [x] 리팩토링 

### 보드 객체 기능
- [x] 말 움직이기 (move)
- [x] 칸의 상태 확인하기 
- [x] 칸의 말을 가져오기
- [x] 칸이 어디에 위치해있는지 (좌표?)

## step 4
- [x] 체스 보드를 html 로 구현한다.
- [x] 체스 피스의 움직임을 html 로 구현한다.
  - [x] 움직일 체스 말을 두 개 클릭한다. 
  - [x] 클릭 순서대로 source, target을 지정한다.
- [ ] 킹이 잡히면 게임을 종료하고, 초기 화면으로 돌아간다.
- [ ] 이동할 수 없는 위치의 경우 메시지를 출력한다.

## step 5
- [ ] 웹 서버를 재시작하더라도 이전에 하던 체스 게임을 다시 할 수 있다.
- [ ] 시작 버튼과 이어하기 버튼 만들기