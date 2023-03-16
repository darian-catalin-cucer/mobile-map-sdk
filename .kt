class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker to the map
        val location = LatLng(37.4220, -122.0841)
        val markerOptions = MarkerOptions().position(location).title("Googleplex")
        map.addMarker(markerOptions)

        // Move the camera to the marker
        val cameraPosition = CameraPosition.Builder().target(location).zoom(17.0f).build()
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }
}
