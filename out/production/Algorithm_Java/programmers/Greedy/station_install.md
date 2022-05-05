# 요구사항

1. 기지국을 최소로 설치하며 모든 아파트에 전파 전달



# 입력

1. 아파트의 개수 : N (int형, 200,000,000 이하의 자연수)
2. 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 : stations(int [] , 크기는 10,000이하 오름차순 정렬) 
3. 전파의 도달거리 : W (int형 10,000 이하의 자연수)



# 출력

증설해야할 기지국 최소 개수



# 문제 파악

유형 : 그리디



# 구현할 기능 목록

1. 주어진 아파트에서 전파가 통하지않는 부분 파악

   stations에서 하나씩 불러와 왼쪽에서 안통하는 부분의 길이를 스택에 담고

   오른쪽에서 안통하는 부분을 시작 인덱스로 바꿔준다.

   (왼쪽부분이 min에 닿으면 오른쪽 부분만 시작 인덱스에)

   (오른쪽 부분이 max에 다으면 stack에 아무것도 넣지 않음.)

   주어진 기지국 번호에서 +- w부분이 전파가 통하는 아파트

   	1. +- 해서 아파트 번호의 max, min 보다 크거나 작으면 max나 min으로 변경

   통하지않는 부분중 연속되지 않는 부분들의 길이를 stack에 담아서 리턴

2. 통하지 않는 부분의 길이를 w로 나눈 몫 이 추가로 설치가 필요하고 만약 나머지가 0이아니라면 1개 추가로 설치 필요.


