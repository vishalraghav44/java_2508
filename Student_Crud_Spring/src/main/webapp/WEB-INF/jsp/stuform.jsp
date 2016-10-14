<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Student</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>Id : </td> 
          <td><form:input path="studentId"  /></td>
         </tr>  
         <tr>  
          <td>Name :</td>  
          <td><form:input path="studentName" /></td>
         </tr> 
         <tr>  
          <td>Marks :</td>  
          <td><form:input path="studentMarks" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
