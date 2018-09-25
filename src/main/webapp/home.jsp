<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
    

        <div class="contenido">
        <!--  <h2>Numero de productos ${numeroProductos}</h2>-->
      	        <c:forEach items="${productos}" var="p">
	      	        <div class="producto">
					<c:if test="${p.descuento>0}">
						<p class="descuento">${p.descuento}&#37;</p>
						<img src="${p.imagen}" alt="imagen-producto" />
	
	                <div class="texto-producto">
						
	                    <p><span class="tachado">${p.precio}&euro;</span><span>${p.calcularDescuento}&euro;</span></p>
	                    <p class="precio-litro">(${p.precioUnidad})</p>
	                    <p>${p.nombre} ${p.descripcion};</p>
	
	                    <div class="cantidad">
	                        <span>&#45;</span> 1 <span>&#43;</span>
	                    </div>
	
	                </div>
					</c:if>
					<c:if test="${p.descuento==0}">
						<img src="${p.imagen}" alt="imagen-producto" />
	    
	                	<div class="texto-producto">
	    
		                    <p class="no-descuento">${p.precio}&euro;</p>
		                    <p class="precio-litro">(${p.precioUnidad})</p>
		                    <p>${p.nombre}${p.descripcion};</p>
		    
		                    <div class="cantidad">
		                            <span>&#45;</span> 1 <span>&#43;</span>
		                    </div>
	    
	                	</div>
	                
					</c:if>
	                
	
	                <a href="#">AÑADIR AL CARRO</a>

           		 </div> <!-- /.producto -->
           		 </c:forEach>

        </div> <!-- /.contenido -->

        <a href="#top" class="top">Top</a>
<%@include file="includes/footer.jsp" %>
       