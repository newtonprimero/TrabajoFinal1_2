<%-- 
    Document   : editar
    Created on : 25 may. 2022, 13:09:07
    Author     : USUARIO
--%>

<div class="modal fade" id="Modificar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form class="form-material">
                <div class="form-group form-default form-static-label">
                    <input type="text" name="footer-email" class="form-control" placeholder="Enter User Name" required="">
                    <span class="form-bar"></span>
                    <label class="float-label">Username</label>
                </div>
                <div class="form-group form-default form-static-label">
                    <input type="text" name="footer-email" class="form-control" placeholder="Enter Email" required="">
                    <span class="form-bar"></span>
                    <label class="float-label">Email (exa@gmail.com)</label>
                </div>
                <div class="form-group form-default form-static-label">
                    <input type="password" name="footer-email" class="form-control" placeholder="Enter Password" required="">
                    <span class="form-bar"></span>
                    <label class="float-label">Password</label>
                </div>
                <div class="form-group form-default form-static-label">
                    <input type="text" name="footer-email" class="form-control" required="" placeholder="Pre define value" value="My value">
                    <span class="form-bar"></span>
                    <label class="float-label">Predefine value</label>
                </div>
                <div class="form-group form-default form-static-label">
                    <input type="text" name="footer-email" class="form-control" required="" placeholder="disabled Input" disabled>
                    <span class="form-bar"></span>
                    <label class="float-label">Disabled</label>
                </div>
                <div class="form-group form-default form-static-label">
                    <input type="text" name="footer-email" class="form-control" required="" maxlength="6" placeholder="Enter only 6 char">
                    <span class="form-bar"></span>
                    <label class="float-label">Max length 6 char</label>
                </div>
                <div class="form-group form-default form-static-label">
                    <textarea class="form-control" required="">Enter Text hear</textarea>
                    <span class="form-bar"></span>
                    <label class="float-label">Text area Input</label>
                </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Understood</button>
          </div>
        </div>
    </div>
</div>
