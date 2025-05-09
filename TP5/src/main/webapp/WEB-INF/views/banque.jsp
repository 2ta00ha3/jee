<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gestion des Comptes Bancaires</title>
    <style>
        div, .table1 th, .table1 td {
            border: 1px dotted gray;
            padding: 10px;
            margin: 10px;
        }
        .table1 th {
            background: pink;
        }
        .table1 td {
            background: white;
        }
    </style>
</head>
<body>
    <div>
        <f:form modelAttribute="banqueForm" action="saveOperation" method="post">
            <table>
                <tr>
                    <td>Code Compte:</td>
                    <td><f:input path="code"/></td>
                    <td><f:errors path="code"/></td>
                </tr>
                <tr>
                    <td>Versement:</td>
                    <td><f:radiobutton path="typeOperation" value="VER"/></td>
                    <td>Retrait:</td>
                    <td><f:radiobutton path="typeOperation" value="RET"/></td>
                    <td>Virement:</td>
                    <td><f:radiobutton path="typeOperation" value="VIR"/></td>
                </tr>
                <c:if test="${not empty banqueForm.typeOperation}">
                    <tr>
                        <td>Montant:</td>
                        <td><f:input path="montant"/></td>
                        <td><f:errors path="montant"/></td>
                    </tr>
                    <c:if test="${banqueForm.typeOperation == 'VIR'}">
                        <tr>
                            <td>Vers le compte:</td>
                            <td><f:input path="code2"/></td>
                            <td><f:errors path="code2"/></td>
                        </tr>
                    </c:if>
                    <tr>
                        <td><input type="submit" name="action" value="save"/></td>
                    </tr>
                </c:if>
            </table>
        </f:form>
    </div>
    <c:if test="${not empty banqueForm.exception}">
        <div>
            <p style="color:red">${banqueForm.exception}</p>
        </div>
    </c:if>
    <c:if test="${not empty banqueForm.compte}">
        <div>
            <table>
                <tr>
                    <td>Solde:</td>
                    <td>${banqueForm.compte.solde}</td>
                </tr>
                <tr>
                    <td>Date Création:</td>
                    <td>${banqueForm.compte.dateCreation}</td>
                </tr>
                <tr>
                    <td>Type de Compte:</td>
                    <td>${banqueForm.typeCompte}</td>
                </tr>
                <c:if test="${banqueForm.typeCompte == 'CompteCourant'}">
                    <tr>
                        <td>Découvert:</td>
                        <td>${banqueForm.compte.decouvert}</td>
                    </tr>
                </c:if>
                <c:if test="${banqueForm.typeCompte == 'CompteEpargne'}">
                    <tr>
                        <td>Taux Intérêt:</td>
                        <td>${banqueForm.compte.tauxInteret}</td>
                    </tr>
                </c:if>
            </table>
        </div>
        <div>
            <table>
                <tr>
                    <td>Nom Client:</td>
                    <td>${banqueForm.compte.client.nomClient}</td>
                </tr>
                <tr>
                    <td>Nom Employé:</td>
                    <td>${banqueForm.compte.employe.nomEmploye}</td>
                </tr>
            </table>
        </div>
    </c:if>
    <c:if test="${not empty banqueForm.operations}">
        <div>
            <table class="table1">
                <tr>
                    <th>Numéro</th>
                    <th>Date</th>
                    <th>Montant</th>
                </tr>
                <c:forEach items="${banqueForm.operations}" var="op">
                    <tr>
                        <td>${op.numeroOperation}</td>
                        <td>${op.dateOperation}</td>
                        <td>${op.montant}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</body>
</html>
