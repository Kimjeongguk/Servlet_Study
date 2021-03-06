<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>푸르지오</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/swiper-bundle.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/swiper-bundle.min.js"></script>
    <script src="js/splitting.min.js"></script>
    <script src="js/main.js" defer></script>
</head>
<body>
    <header id="header" class="pattern01 fulldown">
        <h1 id="logo">
            <a href=""><img src="images/logo.png" alt="로고"></a>
        </h1>
        <nav id="gnb">
            <ul class="gnbList">
                <li>
                    <a href="" class="depth01">프르지오 아트홀</a>
                    <ul class="depth02">
                        <li><a href="">푸르지오아트홀 소개</a></li>
                        <li><a href="">좌석배치도</a></li>
                        <li><a href="">공연장갤러리</a></li>
                        <li><a href="">오시는길</a></li>
                    </ul>
                </li>
                <li>
                    <a href="" class="depth01">공연예매</a>
                    <ul class="depth02">
                        <li><a href="">캘린더</a></li>
                        <li><a href="">진행 중 공연</a></li>
                        <li><a href="">예정 중 공연</a></li>
                        <li><a href="">지난 공연</a></li>
                    </ul>
                </li>
                <li>
                    <a href="" class="depth01">대관신청</a>
                    <ul class="depth02">
                        <li><a href="">대관 절차 / 비용</a></li>
                        <li><a href="">대관 신청</a></li>
                    </ul>
                </li>
                <li>
                    <a href="" class="depth01">녹음문의</a>
                    <ul class="depth02">
                        <li><a href="">이용안내</a></li>
                        <li><a href="">녹음 장비 소개</a></li>
                        <li><a href="">녹음 문의</a></li>
                    </ul>
                </li>
                <li>
                    <a href="" class="depth01">공지사항</a>
                    <ul class="depth02">
                        <li><a href="">공지사항</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </header>
    <!--header end-->
    <div id="mainVisual">
        <ul class="swiper-wrapper visualList">
        <!--  여기에 DB에 있는 것들 받아서 반복 처리.... -->
	        <c:forEach var="visual" items="${visualList}" >
				<li class="visual01 swiper-slide">
	                <div class="img" style="background-image:url('upload_visual/${visual.realVisual}')">
	                </div>
	                <div class="slogan">
	                    <p><span>${visual.contents01}</span></p>
	                    <p><span>${visual.contents02}</span></p>
	                </div>
	            </li>
            </c:forEach>
        </ul>
        <button class="btn prev"><img src="images/prev_bx.png" alt=""></button>
        <button class="btn next"><img src="images/next_bx.png" alt=""></button>
        <div class="pagination"></div>
    </div>
    <!--mainVisual end-->
    <div id="motto" class="section">
        <div class="container">
            <div class="title">
                
            </div>
            <div class="contents">
                <p class="main">
                    SHARING PLACE TO SHARE JOY AND <br>
                    IMPRESSION THROUGH CULTURAL ART
                    <a href="">more view</a>
                </p>
                <p class="sub">
                    문화예술을 통한 즐거움과 감동을 공유하는 나눔터 <br>
                    푸르지오는 깨끗함, 싱그러움을 표현하는 "푸르다"라는 <br>
                    순우리말에 대지, 공간을 뜻하는 "GEO"를 결합하는 것으로 <br>
                    사람, 자연, 그리고 환경이 하나 된 차원 높은 생활 문화 공간을 의미한다.
                </p>
            </div>
        </div>
    </div>
    <div id="notice" class="section">
        <div class="container">
            <div class="title">
                <h2>
                    <span class="kor">공지사항</span>
                    <span class="eng">Notice</span>
                </h2>
                <p>푸르지오아트홀 소식입니다.</p>
            </div>
            <div class="contents">
                <ul>
                    <li>
                        <a href="">
                            <div class="dateBox">
                                <span class="date">05</span>
                                <span class="year">2021.03</span>
                            </div>
                            <div class="desc">
                                <p>covid19 관련 유의사항</p>
                            </div>
                        </a>
                        <div class="answer">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum, eaque pariatur minima saepe labore commodi placeat cumque nulla facilis dolores! Numquam corporis nisi inventore asperiores perferendis laboriosam repudiandae nihil natus modi, aspernatur similique sequi repellendus mollitia fuga totam? Odio nobis amet dolorum accusantium aut quasi itaque ea cum architecto quis delectus dolores nulla sunt quidem alias quo voluptas, laborum ipsa sint! Nesciunt ipsa, aspernatur veritatis earum sint iusto dignissimos, ullam aliquid quia laudantium at accusantium cupiditate animi, exercitationem quos labore hic vero nulla optio. Aut dolores fugiat eum unde possimus nesciunt optio, ad voluptatem eius aperiam dolorem culpa, quibusdam corporis!
                        </div>
                    </li>
                    <li>
                        <a href="">
                            <div class="dateBox">
                                <span class="date">05</span>
                                <span class="year">2021.03</span>
                            </div>
                            <div class="desc">
                                <p>covid19 관련 유의사항</p>
                            </div>
                        </a>
                        <div class="answer">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum, eaque pariatur minima saepe labore commodi placeat cumque nulla facilis dolores! Numquam corporis nisi inventore asperiores perferendis laboriosam repudiandae nihil natus modi, aspernatur similique sequi repellendus mollitia fuga totam? Odio nobis amet dolorum accusantium aut quasi itaque ea cum architecto quis delectus dolores nulla sunt quidem alias quo voluptas, laborum ipsa sint! Nesciunt ipsa, aspernatur veritatis earum sint iusto dignissimos, ullam aliquid quia laudantium at accusantium cupiditate animi, exercitationem quos labore hic vero nulla optio. Aut dolores fugiat eum unde possimus nesciunt optio, ad voluptatem eius aperiam dolorem culpa, quibusdam corporis!
                        </div>
                    </li>
                    <li>
                        <a href="">
                            <div class="dateBox">
                                <span class="date">05</span>
                                <span class="year">2021.03</span>
                            </div>
                            <div class="desc">
                                <p>covid19 관련 유의사항</p>
                            </div>
                        </a>
                        <div class="answer">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum, eaque pariatur minima saepe labore commodi placeat cumque nulla facilis dolores! Numquam corporis nisi inventore asperiores perferendis laboriosam repudiandae nihil natus modi, aspernatur similique sequi repellendus mollitia fuga totam? Odio nobis amet dolorum accusantium aut quasi itaque ea cum architecto quis delectus dolores nulla sunt quidem alias quo voluptas, laborum ipsa sint! Nesciunt ipsa, aspernatur veritatis earum sint iusto dignissimos, ullam aliquid quia laudantium at accusantium cupiditate animi, exercitationem quos labore hic vero nulla optio. Aut dolores fugiat eum unde possimus nesciunt optio, ad voluptatem eius aperiam dolorem culpa, quibusdam corporis!
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>