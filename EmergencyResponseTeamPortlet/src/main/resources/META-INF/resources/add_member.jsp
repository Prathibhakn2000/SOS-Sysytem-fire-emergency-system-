<%@ include file="/init.jsp" %>

<h3>Add Member</h3>

<portlet:actionURL name="/add_member_action" var="addMemberActionURL" />

<form action="${addMemberActionURL}" method="post" name="fm">
   <input type="hidden" name="<portlet:namespace />userGroupId" value="${userGroupId != null ? userGroupId : 0}" />

    <div class="form-group">
        <label>First Name</label>
        <input name="<portlet:namespace />firstName" class="form-control" required />
    </div>

    <div class="form-group">
        <label>Last Name</label>
        <input name="<portlet:namespace />lastName" class="form-control" required />
    </div>

    <div class="form-group">
        <label>Email</label>
        <input type="email" name="<portlet:namespace />email" class="form-control" required />
    </div>

    <div class="form-group">
        <label>Screen Name</label>
        <input name="<portlet:namespace />screenName" class="form-control" required />
    </div>

    <div class="form-group">
        <label>Password</label>
        <input type="password" name="<portlet:namespace />password" class="form-control" required />
    </div>

    <button type="submit" class="btn btn-success">Add Member</button>
</form>
