<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Student</h1>
       <form:form method="POST" action="/Student_Crud_Spring/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="studentId" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="studentName"  /></td>
         </tr>  
         <tr>  
          <td>Marks :</td>  
          <td><form:input path="studentMarks" /></td>
         </tr> 
         <%-- <tr>  
          <td>Designation :</td>  
          <td><form:input path="designation" /></td>
         </tr>  --%>
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
