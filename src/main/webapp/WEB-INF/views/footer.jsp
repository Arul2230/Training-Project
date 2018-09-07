<footer class="footer font-small darkcyan">

  <div class="footer-copyright text-center py-3">Contact us@:arulmurugan@gmail.com</a>
  </div>

</footer>
   <script src="/resources/js/jquery.min.js"></script>
   <script src="/resources/js/jquery-ui.min.js"></script>
   <script src="/resources/js/jquery-migrate-1.2.1.js"></script>
   <script src="/resources/js/bootstrap.min.js"></script>
<script>
function checkbox() {

function FillPermanent(f) {
  if(f.permanent.checked == true) {
    f.permanentDoorNumber.value = f.presentDoorNumber.value;
    f.permanentStreetName.value = f.presentStreetName.value;
    f.permanentCity.value = f.presentCity.value;
    f.permanentState.value = f.presentState.value;
    f.permanentPostcode.value = f.presentPostcode.value;
    f.permanentCountry.value = f.presentCountry.value;
  }
}
</script>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
document.getElementById("DOB").max = new Date(new Date().getTime() - new Date().getTimezoneOffset() *   
     60000).toISOString().split("T")[0];
     document.getElementById("DOJ").max = new Date(new Date().getTime() - new Date().getTimezoneOffset() *   
     60000).toISOString().split("T")[0];
</script>
