<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-integer code="administrator.dashboard.form.label.totalAnnouncement" path="totalAnnouncement"/>
	<acme:form-integer code="administrator.dashboard.form.label.totalCompanyRecord" path="totalCompanyRecord"/>
	<acme:form-integer code="administrator.dashboard.form.label.totalInvestorRecords" path="totalInvestorRecords"/>
	
	<acme:form-double code="administrator.dashboard.form.label.minRewardsSolicit" path="minRewardsSolicit"/>
	<acme:form-double code="administrator.dashboard.form.label.maxRewardsSolicit" path="maxRewardsSolicit"/>
	<acme:form-double code="administrator.dashboard.form.label.avgRewardsSolicit" path="avgRewardsSolicit"/>
	<acme:form-double code="administrator.dashboard.form.label.stdRewardsSolicit" path="stdRewardsSolicit"/>
	
	<acme:form-double code="administrator.dashboard.form.label.minRewardsOffer" path="minRewardsOffer"/>
	<acme:form-double code="administrator.dashboard.form.label.maxRewardsOffer" path="maxRewardsOffer"/>
	<acme:form-double code="administrator.dashboard.form.label.avgRewardsOffer" path="avgRewardsOffer"/>
	<acme:form-double code="administrator.dashboard.form.label.stdRewardsOffer" path="stdRewardsOffer"/>
	
	
	
	<div>
		<canvas id="canvas1"></canvas>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			var data = {
					labels : [
						""
						<jstl:forEach var="par" items="${sectorNumberCompanyRecord}">
							,<jstl:out value="${par[0]}"/>
						</jstl:forEach>
					],
					datasets : [
						{
							data : [
								0,
								1,
								3,
								2
							]
						}						
					]
			};
			var options = {
					legend : {
						display : false
					}
			};
			var canvas, context;
			
			canvas = document.getElementById("canvas1");
			context = canvas.getContext("2d");
			new Chart(context, {
				type : "bar",
				data : data,
				options : options
			});
		});
	</script>
	
	
	<acme:form-return code="administrator.dashboard.form.button.return"/>
</acme:form>