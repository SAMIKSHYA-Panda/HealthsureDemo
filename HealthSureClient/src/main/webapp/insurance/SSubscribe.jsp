<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <title>Subscribe to Insurance Plan</title>
</head>
<body>
    <f:view>
        <h:form>

    <h3>Subscribe to Plan</h3>

    <h:panelGrid columns="2" cellpadding="5">

        <h:outputLabel value="First Name:" for="firstName" />
        <h:inputText id="firstName" value="#{subscriptionController.recipient.firstName}" required="true" />

        <h:outputLabel value="Last Name:" for="lastName" />
        <h:inputText id="lastName" value="#{subscriptionController.recipient.lastName}" required="true" />

        <h:outputLabel value="Email:" for="email" />
        <h:inputText id="email" value="#{subscriptionController.recipient.email}" required="true" />

        <h:outputLabel value="mobile:" for="mobile" />
        <h:inputText id="mobile" value="#{subscriptionController.recipient.mobile}" required="true" />

        <h:outputLabel value="Date of Birth:" for="dob" />
        <h:inputText id="dob" value="#{subscriptionController.recipient.dob}" required="true">
            <f:convertDateTime pattern="yyyy-MM-dd" />
        </h:inputText>

        <h:outputLabel value="Address:" for="address" />
        <h:inputText id="address" value="#{subscriptionController.recipient.address}" required="true" />

    </h:panelGrid>

    <br/>

    <h:commandButton value="Submit Subscription" action="#{subscriptionController.saveSubscription}" />

</h:form>
    </f:view>
</body>
</html>