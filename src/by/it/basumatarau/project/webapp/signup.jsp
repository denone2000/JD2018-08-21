<html lang="en">
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<p>Cmd Sign-up: ${message}</p>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Sign Up</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Login</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" placeholder="placeholder" class="form-control input-md" required="" type="text">
  <span class="help-block">help</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password</label>
  <div class="col-md-4">
    <input id="passwordinput" name="passwordinput" placeholder="placeholder" class="form-control input-md" required="" type="password">
    <span class="help-block">help</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Sign me up</button>
  </div>
</div>

</fieldset>
</form>

</body>
</html>




