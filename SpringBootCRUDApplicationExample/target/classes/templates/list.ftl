<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Add student</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.student.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.student.name" id="uname" class="studentname form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="age">Surname</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.student.surname" id="surname" class="form-control input-sm" placeholder="Enter your Surname." ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="university">University</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.university" id="university" class="form-control input-sm" placeholder="Enter your University." required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="age">Faculty</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.faculty" id="faculty" class="form-control input-sm" placeholder="Enter your Faculty." ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="age">Group</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.group" id="group" class="form-control input-sm" placeholder="Enter your Group." ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="age">Room</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.room" id="room" class="form-control input-sm" placeholder="Enter your Room." ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.student.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>

	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Students </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>NAME</th>
		                <th>SURNAME</th>
		                <th>UNIVERSITY</th>
						<th>FACULTY</th>
						<th>GROUP</th>
						<th>ROOM</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllStudents()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.surname}}</td>
		                <td>{{u.university}}</td>
						<td>{{u.faculty}}</td>
                        <td>{{u.group}}</td>
                        <td>{{u.room}}</td>
		                <td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>