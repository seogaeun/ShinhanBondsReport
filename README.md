## 신한투자증권 채권 가상투자 서비스 재구성해보기 - 채권 가상 투자 리포트
### 이 글에서는 신한투자증권 채권 가상투자 서비스에 디자인패턴을 도입하여 재구성하게 된 배경과 그 과정을 담아내고자 합니다.

 이번 리팩토링 프로젝트를 통해 채권 시장에 대한 이해도를 높이고, 신한투자증권의 채권 가상투자 서비스를 더욱 현대적이고 사용자 친화적인 방향으로 발전시켜 채권 투자에 대한 잠재고객을 끌어올 수 있기를 희망합니다.

 다음은 위와 같은 신한투자증권의 채권 가상투자 서비스 중 중점을 두어 저만의 방식으로 재구성해본 고려 사항입니다.

---

1. **State 패턴**을 사용하여 장내채권 매매시간( 평일 오전 9:00 ~ 15:30 ) 상태에 따른 다른 대응 적용
2. 채권의 이자 및 원금지급방법(복리채, 단리채, 할인채, 이표채)에 따라 채권 정형화 한 뒤, 채권 생성시 **Factory Method 사용**
3. **Facade**를 통한 고객 채권 투자 리포트 생성 간편화

---
   

[프로젝트 전체 UML Class Diagram](https://github.com/seogaeun/ShinhanBondsReport/blob/b2b4f636526ac02c699e6079ad6dbb5ea548f1e9/%EC%B1%84%EA%B6%8C%20%EC%84%A4%EA%B3%84%20%EC%A0%84%EC%B1%84%20UML%20%ED%81%B4%EB%9E%98%EC%8A%A4%20%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8.pdf) 👻

[프로젝트 깃헙](https://github.com/seogaeun/ShinhanBondsReport) 🐈‍⬛

[프로젝트 기술 문서 깃헙](<./기술문서 Markdown.md>) 🛠️ | 
[프로젝트 기술 문서 노션](https://www.notion.so/57420225a93e4aef8552f699c3f73aa6?pvs=21) 📙

Projected by Gaeun:)

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fseogaeun%2FShinhanBondsReport&count_bg=%235BA8FF&title_bg=%23878585&icon=&icon_color=%23E7E7E7&title=Hi%2C+visitor%21&edge_flat=false)](https://hits.seeyoufarm.com)
