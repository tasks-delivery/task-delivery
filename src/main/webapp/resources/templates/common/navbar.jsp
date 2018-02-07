<div class="contain-to-grid fixed">
	<nav class="top-bar" data-topbar="">
		<div class="top-bar-section">
		    <ul class="left">
		       <c:if test="${pageContext.request.userPrincipal.name == null}">
		        <li><a href="/" class="collapse-only">
                    <img src="${contextPath}/resources/img/bomb.png">
                    <span>Task-delivery</span></a>
                </li>
               </c:if>
               <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><a href="/dashboard" class="collapse-only">
                    <img src="${contextPath}/resources/img/bomb.png">
                    <span>Task-delivery</span></a>
                </li>
               </c:if>
            </ul>
		    <ul class="center">
		    	<li><a href="/docs">Docs</a></li>
		    	<li><a href="/support">Support</a></li>
		    	<li><a href="/blog">Blog</a></li>
		    	<li><a href="/about">About</a></li>
		    </ul>
		    <ul class="right">
               <c:if test="${pageContext.request.userPrincipal.name == null}">
               <li><a href="/login"  id="btnReg">Sign up</a></li>
               </c:if>
               <c:if test="${pageContext.request.userPrincipal.name != null}">
               <form id="logoutForm" method="POST" action="${contextPath}/logout">
               </form>
               <h5 class="welcome-user">Welcome ${pageContext.request.userPrincipal.name}</h5>
               <h5 class="separate">|</h5>
               <a class="btn-logout" onclick="document.forms['logoutForm'].submit()">Logout</a>
               </c:if>
            </ul>
		</div>
	</nav>
</div>

