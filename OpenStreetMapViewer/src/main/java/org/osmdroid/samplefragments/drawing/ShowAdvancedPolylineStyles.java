package org.osmdroid.samplefragments.drawing;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import org.osmdroid.R;
import org.osmdroid.samplefragments.BaseSampleFragment;
import org.osmdroid.util.BoundingBox;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.advancedpolyline.ColorMapping;
import org.osmdroid.views.overlay.advancedpolyline.ColorMappingRanges;
import org.osmdroid.views.overlay.advancedpolyline.PolylineStyle;
import org.osmdroid.views.overlay.infowindow.InfoWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Showing all modes of advanced polyline styles with example data.
 * @author Matthias Dittmer
 */
public class ShowAdvancedPolylineStyles extends BaseSampleFragment {

    /**
     * List with all examples.
     */
    ArrayList<AdvancedPolylineExample> mListExamples = new ArrayList<>();

    @Override
    public String getSampleTitle() {
        return "Show advanced polyline styles";
    }

    @Override
    public void addOverlays(){
        super.addOverlays();
        addSamplePolylines();
    }

    public void addSamplePolylines() {

        // setup all examples
        setupExamples();

        // add all examples from array
        for(AdvancedPolylineExample example: mListExamples) {
            mMapView.getOverlayManager().add(example.getPolyline());
            // show info window so line is easy to spot for user
            example.getPolyline().showInfoWindow();
        }
    }

    /**
     * Class to hold on example.
     */
    class AdvancedPolylineExample {

        private Polyline mPolyline;
        private PolylineStyle mPolylineStyle;
        private InfoWindowExample mInfoWindow;
        private BoundingBox mBoundingBox;

        public AdvancedPolylineExample(final String title, final String description,
                                       final ColorMapping mapping, final Boolean gradient,
                                       final Boolean border, final Integer borderColor,
                                       ArrayList<GeoPoint> points, ArrayList<Float> scalar) {
            // setup polyline
            mPolyline = new Polyline();
            mPolyline.setWidth(20.0f);

            // setup style
            mPolylineStyle = new PolylineStyle(mapping, gradient);
            if(border) {
                mPolylineStyle.setBorder(25.0f, borderColor);
            }
            mPolyline.setStyle(mPolylineStyle);

            // add points and scalar
            mPolyline.setPoints(points, scalar);

            // set a bounding box from points, plus 1.2f scaled
            mBoundingBox = BoundingBox.fromGeoPoints(points).increaseByScale(1.2f);

            // add infowindow
            mInfoWindow = new InfoWindowExample(R.layout.bonuspack_bubble, mMapView);
            mInfoWindow.setText(title, description);
            mPolyline.setInfoWindow(mInfoWindow);
        }

        public final Polyline getPolyline() {
            return mPolyline;
        }
    }

    /**
     * Infowindow
     */
    class InfoWindowExample extends InfoWindow {

        public InfoWindowExample(int layoutResId, MapView mapView) {
            super(layoutResId, mapView);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    close();
                }
            });
        }

        public void setText(String title, String description) {
            ((TextView)getView().findViewById(R.id.bubble_title)).setText(title);
            ((TextView)getView().findViewById(R.id.bubble_description)).setText(description);
        }

        @Override
        public void onOpen(Object item) {

        }

        @Override
        public void onClose() {

        }
    }

    private void setupExamples() {

        // Ranges example
        SortedMap<Float, Integer> mColorRanges = new TreeMap<>();
        mColorRanges.put(5.0f, Color.RED);
        mColorRanges.put(7.5f, Color.YELLOW);
        mColorRanges.put(10.0f, Color.GREEN);
        mListExamples.add(new AdvancedPolylineExample("Tram", "Ranges polyline with border showing a tram ride between airport and main train station.\n\nBorders: 5 m/s RED, 7.5 m/s YELLOW, 10.0 m/s GREEN.",
                new ColorMappingRanges(mColorRanges), false, true, Color.BLACK, mExampleTramPoints, mExampleTramScalar));

    }

    // Below follows hardcoded polyline data (points and scalars) for examples.
    // Data was taken from various sources (self recorded or free online data sources).
    ArrayList<GeoPoint> mExampleTramPoints = new ArrayList<>(
            Arrays.asList(
                    new GeoPoint(53.052895, 8.786615),
                    new GeoPoint(53.053312, 8.786103),
                    new GeoPoint(53.053195, 8.786022),
                    new GeoPoint(53.053103, 8.785943),
                    new GeoPoint(53.053052, 8.786077),
                    new GeoPoint(53.053112, 8.785962),
                    new GeoPoint(53.05308, 8.785822),
                    new GeoPoint(53.05298, 8.785783),
                    new GeoPoint(53.052885, 8.785787),
                    new GeoPoint(53.05287, 8.786067),
                    new GeoPoint(53.052947, 8.786208),
                    new GeoPoint(53.053045, 8.786167),
                    new GeoPoint(53.05314, 8.786055),
                    new GeoPoint(53.053145, 8.785862),
                    new GeoPoint(53.053232, 8.785625),
                    new GeoPoint(53.053247, 8.785477),
                    new GeoPoint(53.053283, 8.785322),
                    new GeoPoint(53.053333, 8.785165),
                    new GeoPoint(53.053377, 8.78501),
                    new GeoPoint(53.053422, 8.784867),
                    new GeoPoint(53.053487, 8.78473),
                    new GeoPoint(53.053577, 8.784527),
                    new GeoPoint(53.053635, 8.784363),
                    new GeoPoint(53.053712, 8.78415),
                    new GeoPoint(53.053777, 8.783953),
                    new GeoPoint(53.05388, 8.783757),
                    new GeoPoint(53.054017, 8.783595),
                    new GeoPoint(53.054147, 8.783425),
                    new GeoPoint(53.054258, 8.783267),
                    new GeoPoint(53.054368, 8.783142),
                    new GeoPoint(53.054463, 8.783032),
                    new GeoPoint(53.054573, 8.782935),
                    new GeoPoint(53.054675, 8.782908),
                    new GeoPoint(53.054775, 8.782792),
                    new GeoPoint(53.054868, 8.782687),
                    new GeoPoint(53.054953, 8.782622),
                    new GeoPoint(53.055047, 8.782578),
                    new GeoPoint(53.055173, 8.782642),
                    new GeoPoint(53.055262, 8.782785),
                    new GeoPoint(53.055465, 8.782883),
                    new GeoPoint(53.055613, 8.783032),
                    new GeoPoint(53.055765, 8.783237),
                    new GeoPoint(53.055868, 8.783413),
                    new GeoPoint(53.055928, 8.78353),
                    new GeoPoint(53.056003, 8.783637),
                    new GeoPoint(53.056102, 8.783707),
                    new GeoPoint(53.05618, 8.783822),
                    new GeoPoint(53.056202, 8.784073),
                    new GeoPoint(53.05627, 8.784215),
                    new GeoPoint(53.056338, 8.784425),
                    new GeoPoint(53.056407, 8.784542),
                    new GeoPoint(53.056487, 8.784662),
                    new GeoPoint(53.056558, 8.784773),
                    new GeoPoint(53.056625, 8.784898),
                    new GeoPoint(53.05669, 8.785027),
                    new GeoPoint(53.056748, 8.785197),
                    new GeoPoint(53.056807, 8.785313),
                    new GeoPoint(53.056863, 8.785433),
                    new GeoPoint(53.056982, 8.785643),
                    new GeoPoint(53.05707, 8.785708),
                    new GeoPoint(53.057192, 8.785745),
                    new GeoPoint(53.057308, 8.785807),
                    new GeoPoint(53.057425, 8.785857),
                    new GeoPoint(53.057545, 8.785867),
                    new GeoPoint(53.057637, 8.785852),
                    new GeoPoint(53.057738, 8.785832),
                    new GeoPoint(53.05788, 8.78574),
                    new GeoPoint(53.057995, 8.785688),
                    new GeoPoint(53.058097, 8.785652),
                    new GeoPoint(53.058198, 8.785608),
                    new GeoPoint(53.058307, 8.785568),
                    new GeoPoint(53.058442, 8.785512),
                    new GeoPoint(53.058543, 8.785492),
                    new GeoPoint(53.058638, 8.785462),
                    new GeoPoint(53.058727, 8.785433),
                    new GeoPoint(53.05901, 8.785322),
                    new GeoPoint(53.059143, 8.785262),
                    new GeoPoint(53.059253, 8.785202),
                    new GeoPoint(53.059488, 8.785083),
                    new GeoPoint(53.059603, 8.785028),
                    new GeoPoint(53.05972, 8.784962),
                    new GeoPoint(53.059812, 8.784863),
                    new GeoPoint(53.059905, 8.784825),
                    new GeoPoint(53.06, 8.784783),
                    new GeoPoint(53.06009, 8.784758),
                    new GeoPoint(53.06019, 8.784742),
                    new GeoPoint(53.060305, 8.784737),
                    new GeoPoint(53.060455, 8.784748),
                    new GeoPoint(53.060593, 8.784802),
                    new GeoPoint(53.060698, 8.784867),
                    new GeoPoint(53.060818, 8.784942),
                    new GeoPoint(53.06093, 8.784977),
                    new GeoPoint(53.06103, 8.785063),
                    new GeoPoint(53.06104, 8.78523),
                    new GeoPoint(53.06111, 8.785332),
                    new GeoPoint(53.061215, 8.785465),
                    new GeoPoint(53.061305, 8.785588),
                    new GeoPoint(53.061397, 8.78572),
                    new GeoPoint(53.061492, 8.785853),
                    new GeoPoint(53.061577, 8.785975),
                    new GeoPoint(53.061667, 8.786087),
                    new GeoPoint(53.061752, 8.786207),
                    new GeoPoint(53.061822, 8.786328),
                    new GeoPoint(53.061893, 8.786463),
                    new GeoPoint(53.061978, 8.786622),
                    new GeoPoint(53.062077, 8.786793),
                    new GeoPoint(53.062145, 8.786895),
                    new GeoPoint(53.062212, 8.786998),
                    new GeoPoint(53.062288, 8.787107),
                    new GeoPoint(53.062348, 8.78723),
                    new GeoPoint(53.06243, 8.787358),
                    new GeoPoint(53.062518, 8.787483),
                    new GeoPoint(53.062607, 8.787593),
                    new GeoPoint(53.062685, 8.787707),
                    new GeoPoint(53.062755, 8.787822),
                    new GeoPoint(53.062825, 8.787932),
                    new GeoPoint(53.062895, 8.788062),
                    new GeoPoint(53.062968, 8.788187),
                    new GeoPoint(53.063043, 8.788297),
                    new GeoPoint(53.063115, 8.788388),
                    new GeoPoint(53.063195, 8.788502),
                    new GeoPoint(53.063277, 8.788597),
                    new GeoPoint(53.063362, 8.788675),
                    new GeoPoint(53.06348, 8.788772),
                    new GeoPoint(53.063647, 8.788993),
                    new GeoPoint(53.06374, 8.789147),
                    new GeoPoint(53.0638, 8.789277),
                    new GeoPoint(53.06392, 8.789452),
                    new GeoPoint(53.06395, 8.789593),
                    new GeoPoint(53.063942, 8.789417),
                    new GeoPoint(53.06385, 8.789383),
                    new GeoPoint(53.063732, 8.789365),
                    new GeoPoint(53.06377, 8.789505),
                    new GeoPoint(53.06383, 8.789632),
                    new GeoPoint(53.06391, 8.78977),
                    new GeoPoint(53.06394, 8.78997),
                    new GeoPoint(53.064047, 8.79017),
                    new GeoPoint(53.064108, 8.7903),
                    new GeoPoint(53.064182, 8.790432),
                    new GeoPoint(53.064275, 8.790545),
                    new GeoPoint(53.06434, 8.790655),
                    new GeoPoint(53.064458, 8.79087),
                    new GeoPoint(53.064535, 8.790992),
                    new GeoPoint(53.064622, 8.791125),
                    new GeoPoint(53.06472, 8.791267),
                    new GeoPoint(53.064852, 8.791387),
                    new GeoPoint(53.064925, 8.791498),
                    new GeoPoint(53.06501, 8.791633),
                    new GeoPoint(53.0651, 8.791762),
                    new GeoPoint(53.065187, 8.791878),
                    new GeoPoint(53.065277, 8.792),
                    new GeoPoint(53.065358, 8.79212),
                    new GeoPoint(53.065462, 8.792255),
                    new GeoPoint(53.065585, 8.792375),
                    new GeoPoint(53.065677, 8.792472),
                    new GeoPoint(53.06572, 8.792698),
                    new GeoPoint(53.065783, 8.792885),
                    new GeoPoint(53.06591, 8.792943),
                    new GeoPoint(53.066005, 8.793023),
                    new GeoPoint(53.065923, 8.793103),
                    new GeoPoint(53.065937, 8.793268),
                    new GeoPoint(53.066022, 8.793387),
                    new GeoPoint(53.066103, 8.79353),
                    new GeoPoint(53.066182, 8.793632),
                    new GeoPoint(53.066318, 8.793787),
                    new GeoPoint(53.066412, 8.79388),
                    new GeoPoint(53.066492, 8.794),
                    new GeoPoint(53.066582, 8.794093),
                    new GeoPoint(53.0667, 8.794193),
                    new GeoPoint(53.066783, 8.794308),
                    new GeoPoint(53.06682, 8.794557),
                    new GeoPoint(53.066893, 8.794685),
                    new GeoPoint(53.066998, 8.794833),
                    new GeoPoint(53.06709, 8.795),
                    new GeoPoint(53.067182, 8.795143),
                    new GeoPoint(53.067273, 8.795302),
                    new GeoPoint(53.067372, 8.795457),
                    new GeoPoint(53.06747, 8.795605),
                    new GeoPoint(53.067563, 8.795743),
                    new GeoPoint(53.067652, 8.795882),
                    new GeoPoint(53.067745, 8.796022),
                    new GeoPoint(53.06784, 8.796152),
                    new GeoPoint(53.067943, 8.796282),
                    new GeoPoint(53.068043, 8.796425),
                    new GeoPoint(53.068188, 8.796573),
                    new GeoPoint(53.068312, 8.79672),
                    new GeoPoint(53.068408, 8.796853),
                    new GeoPoint(53.06849, 8.796983),
                    new GeoPoint(53.068547, 8.797197),
                    new GeoPoint(53.068583, 8.797375),
                    new GeoPoint(53.068715, 8.797528),
                    new GeoPoint(53.068852, 8.79769),
                    new GeoPoint(53.068937, 8.797768),
                    new GeoPoint(53.06903, 8.797862),
                    new GeoPoint(53.069123, 8.797928),
                    new GeoPoint(53.069208, 8.79801),
                    new GeoPoint(53.069303, 8.798087),
                    new GeoPoint(53.069392, 8.798152),
                    new GeoPoint(53.069515, 8.798342),
                    new GeoPoint(53.06961, 8.798518),
                    new GeoPoint(53.069665, 8.7987),
                    new GeoPoint(53.069758, 8.798862),
                    new GeoPoint(53.069817, 8.799005),
                    new GeoPoint(53.069882, 8.79913),
                    new GeoPoint(53.069978, 8.799257),
                    new GeoPoint(53.070067, 8.799317),
                    new GeoPoint(53.070158, 8.79953),
                    new GeoPoint(53.070288, 8.799712),
                    new GeoPoint(53.070395, 8.799852),
                    new GeoPoint(53.0705, 8.799958),
                    new GeoPoint(53.070655, 8.800083),
                    new GeoPoint(53.070748, 8.800183),
                    new GeoPoint(53.070848, 8.800272),
                    new GeoPoint(53.070968, 8.80037),
                    new GeoPoint(53.071148, 8.800498),
                    new GeoPoint(53.071345, 8.800665),
                    new GeoPoint(53.07145, 8.800803),
                    new GeoPoint(53.071378, 8.801298),
                    new GeoPoint(53.071412, 8.801447),
                    new GeoPoint(53.071437, 8.801632),
                    new GeoPoint(53.071462, 8.801855),
                    new GeoPoint(53.071532, 8.802115),
                    new GeoPoint(53.071623, 8.802367),
                    new GeoPoint(53.071628, 8.802522),
                    new GeoPoint(53.071692, 8.802697),
                    new GeoPoint(53.071798, 8.802867),
                    new GeoPoint(53.071922, 8.803018),
                    new GeoPoint(53.071992, 8.803128),
                    new GeoPoint(53.072067, 8.803228),
                    new GeoPoint(53.072162, 8.80334),
                    new GeoPoint(53.072258, 8.803448),
                    new GeoPoint(53.073832, 8.806852),
                    new GeoPoint(53.073883, 8.807),
                    new GeoPoint(53.07399, 8.807212),
                    new GeoPoint(53.074078, 8.807408),
                    new GeoPoint(53.074172, 8.80762),
                    new GeoPoint(53.074263, 8.80782),
                    new GeoPoint(53.074355, 8.808022),
                    new GeoPoint(53.074453, 8.808205),
                    new GeoPoint(53.074608, 8.810155),
                    new GeoPoint(53.074537, 8.810365),
                    new GeoPoint(53.074537, 8.810543),
                    new GeoPoint(53.074635, 8.810658),
                    new GeoPoint(53.074703, 8.810782),
                    new GeoPoint(53.074768, 8.811005),
                    new GeoPoint(53.074845, 8.811165),
                    new GeoPoint(53.074962, 8.811378),
                    new GeoPoint(53.075072, 8.81149),
                    new GeoPoint(53.075232, 8.811577),
                    new GeoPoint(53.075363, 8.811612),
                    new GeoPoint(53.075453, 8.81163),
                    new GeoPoint(53.07555, 8.811642),
                    new GeoPoint(53.075738, 8.811593),
                    new GeoPoint(53.075847, 8.811543),
                    new GeoPoint(53.075967, 8.811493),
                    new GeoPoint(53.076077, 8.811428),
                    new GeoPoint(53.07616, 8.811358),
                    new GeoPoint(53.07624, 8.811288),
                    new GeoPoint(53.076317, 8.811188),
                    new GeoPoint(53.07646, 8.811023),
                    new GeoPoint(53.076533, 8.810935),
                    new GeoPoint(53.076707, 8.810678),
                    new GeoPoint(53.076885, 8.810525),
                    new GeoPoint(53.07696, 8.810418),
                    new GeoPoint(53.077082, 8.810375),
                    new GeoPoint(53.07718, 8.810402),
                    new GeoPoint(53.077292, 8.810448),
                    new GeoPoint(53.077373, 8.81052),
                    new GeoPoint(53.077312, 8.810302),
                    new GeoPoint(53.077292, 8.810153),
                    new GeoPoint(53.077535, 8.809693),
                    new GeoPoint(53.077598, 8.809518),
                    new GeoPoint(53.07763, 8.809367),
                    new GeoPoint(53.077685, 8.809233),
                    new GeoPoint(53.077763, 8.809142),
                    new GeoPoint(53.077833, 8.80902),
                    new GeoPoint(53.077918, 8.808945),
                    new GeoPoint(53.078012, 8.808877),
                    new GeoPoint(53.078113, 8.808828),
                    new GeoPoint(53.078208, 8.808932),
                    new GeoPoint(53.078285, 8.809022),
                    new GeoPoint(53.07841, 8.809117),
                    new GeoPoint(53.078493, 8.809197),
                    new GeoPoint(53.078585, 8.809257),
                    new GeoPoint(53.078737, 8.80933),
                    new GeoPoint(53.07887, 8.809445),
                    new GeoPoint(53.078998, 8.809537),
                    new GeoPoint(53.079107, 8.809588),
                    new GeoPoint(53.079232, 8.80966),
                    new GeoPoint(53.079317, 8.809733),
                    new GeoPoint(53.079465, 8.809863),
                    new GeoPoint(53.079553, 8.809967),
                    new GeoPoint(53.079648, 8.810017),
                    new GeoPoint(53.079753, 8.810112),
                    new GeoPoint(53.079837, 8.810275),
                    new GeoPoint(53.079918, 8.810427),
                    new GeoPoint(53.080037, 8.8105),
                    new GeoPoint(53.080068, 8.81068),
                    new GeoPoint(53.080017, 8.810812),
                    new GeoPoint(53.079985, 8.810997),
                    new GeoPoint(53.08007, 8.81107),
                    new GeoPoint(53.080167, 8.811058),
                    new GeoPoint(53.080278, 8.811005),
                    new GeoPoint(53.080417, 8.810985),
                    new GeoPoint(53.080507, 8.810993),
                    new GeoPoint(53.080678, 8.81098),
                    new GeoPoint(53.08146, 8.811538),
                    new GeoPoint(53.081567, 8.811638),
                    new GeoPoint(53.081638, 8.81175),
                    new GeoPoint(53.081613, 8.811958),
                    new GeoPoint(53.081788, 8.812355),
                    new GeoPoint(53.081847, 8.812493),
                    new GeoPoint(53.081897, 8.812628),
                    new GeoPoint(53.0819, 8.812783),
                    new GeoPoint(53.081845, 8.81295),
                    new GeoPoint(53.081765, 8.813102),
                    new GeoPoint(53.081698, 8.813205),
                    new GeoPoint(53.081645, 8.813328)
            )
    );

    ArrayList<Float> mExampleTramScalar = new ArrayList<>(
            Arrays.asList(
                    0f,
                    0f,
                    0f,
                    0f,
                    0f,
                    0f,
                    0f,
                    2.12f,
                    1.46f,
                    0f,
                    0f,
                    0f,
                    0f,
                    2.8f,
                    3.97f,
                    6.51f,
                    5.61f,
                    5.38f,
                    5.27f,
                    5.76f,
                    5.65f,
                    5.85f,
                    6.21f,
                    7.11f,
                    7.57f,
                    8.55f,
                    9.08f,
                    8.66f,
                    8.65f,
                    8.55f,
                    8.13f,
                    6.98f,
                    7.04f,
                    3.5f,
                    4.54f,
                    4.79f,
                    4.95f,
                    4.6f,
                    4.63f,
                    5.8f,
                    7.33f,
                    7.76f,
                    8.54f,
                    6.92f,
                    5.34f,
                    0.43f,
                    0f,
                    0f,
                    4.08f,
                    5.72f,
                    7.17f,
                    8.02f,
                    8.68f,
                    9.04f,
                    9.38f,
                    9.71f,
                    10.21f,
                    10.18f,
                    10.17f,
                    9.89f,
                    9.6f,
                    9.27f,
                    9.38f,
                    7.82f,
                    8.25f,
                    8.27f,
                    9.05f,
                    11.61f,
                    11.64f,
                    11.52f,
                    11.52f,
                    11.63f,
                    12.13f,
                    11.9f,
                    11.73f,
                    11.44f,
                    12.22f,
                    12.61f,
                    12.38f,
                    11.27f,
                    11.13f,
                    10.46f,
                    10.37f,
                    10.24f,
                    10.22f,
                    10f,
                    8.92f,
                    8.58f,
                    8.39f,
                    7.23f,
                    7.01f,
                    6.98f,
                    6.58f,
                    4.57f,
                    0f,
                    0f,
                    6.37f,
                    6.65f,
                    6.15f,
                    6.49f,
                    6.3f,
                    6.2f,
                    6.13f,
                    5.73f,
                    5.95f,
                    6.5f,
                    7.41f,
                    8.39f,
                    8.99f,
                    9.67f,
                    10.1f,
                    10.62f,
                    11.13f,
                    11.46f,
                    11.46f,
                    11.23f,
                    11.03f,
                    11.17f,
                    11.29f,
                    11.14f,
                    10.65f,
                    10.18f,
                    8.87f,
                    8.53f,
                    8.27f,
                    7.37f,
                    6.82f,
                    5.29f,
                    5.8f,
                    3.29f,
                    1.88f,
                    0f,
                    0f,
                    0f,
                    4.44f,
                    5.62f,
                    6.76f,
                    8.01f,
                    8.62f,
                    9.18f,
                    9.77f,
                    9.99f,
                    10.56f,
                    11.31f,
                    11.68f,
                    12f,
                    12.76f,
                    12.68f,
                    12.67f,
                    12.36f,
                    12.15f,
                    12.15f,
                    11.95f,
                    11.93f,
                    11.81f,
                    11.12f,
                    9.15f,
                    7.86f,
                    5.58f,
                    4.82f,
                    0f,
                    0f,
                    4.73f,
                    5.56f,
                    5.23f,
                    6.75f,
                    7.93f,
                    8.85f,
                    9.56f,
                    12.02f,
                    11.5f,
                    11.22f,
                    11.7f,
                    13f,
                    13.41f,
                    12.58f,
                    13.14f,
                    13.75f,
                    13.95f,
                    13.94f,
                    13.84f,
                    13.87f,
                    13.69f,
                    13.7f,
                    13.59f,
                    13.72f,
                    13.81f,
                    13.66f,
                    13.03f,
                    8.88f,
                    6.65f,
                    6.93f,
                    7.31f,
                    9.8f,
                    11.03f,
                    11.47f,
                    12.24f,
                    13.11f,
                    12.97f,
                    10.91f,
                    9.11f,
                    7.17f,
                    6.76f,
                    6.01f,
                    2.21f,
                    0f,
                    5.49f,
                    6.31f,
                    7.53f,
                    6.39f,
                    6.47f,
                    6.02f,
                    5.93f,
                    6.9f,
                    6.66f,
                    6.82f,
                    7.75f,
                    7.41f,
                    10.36f,
                    9.69f,
                    7.78f,
                    7.56f,
                    8.7f,
                    8.89f,
                    7.78f,
                    7.64f,
                    8.48f,
                    7.97f,
                    6.89f,
                    6.37f,
                    6.38f,
                    6.38f,
                    9.73f,
                    9.92f,
                    8.51f,
                    8.15f,
                    8.52f,
                    8.4f,
                    8.42f,
                    0.01f,
                    8.12f,
                    6.39f,
                    5.91f,
                    7.12f,
                    7.47f,
                    7.14f,
                    6.33f,
                    5.53f,
                    6.35f,
                    6.66f,
                    6.32f,
                    6.85f,
                    7.38f,
                    8.16f,
                    8.55f,
                    9.03f,
                    9.33f,
                    9.12f,
                    8.84f,
                    8.97f,
                    8.91f,
                    8.91f,
                    8.07f,
                    6.43f,
                    4.79f,
                    3.08f,
                    3.2f,
                    3.59f,
                    3.71f,
                    0f,
                    0f,
                    4.91f,
                    5.71f,
                    5.35f,
                    5.34f,
                    4.37f,
                    3.62f,
                    3.39f,
                    3.43f,
                    2.41f,
                    3.27f,
                    4.66f,
                    6.26f,
                    6.85f,
                    7.04f,
                    7.48f,
                    7.65f,
                    7.81f,
                    7.79f,
                    7.47f,
                    7.48f,
                    7.23f,
                    5.41f,
                    2.54f,
                    0f,
                    3.77f,
                    4.22f,
                    3.99f,
                    3.84f,
                    1.83f,
                    2.29f,
                    2.25f,
                    2.01f,
                    2.27f,
                    2.94f,
                    3.6f,
                    4.88f,
                    4.76f,
                    5.07f,
                    5.33f,
                    3.16f,
                    3.06f,
                    2.89f,
                    3.01f,
                    3.22f,
                    4.19f,
                    4.42f,
                    4.72f,
                    2.83f
            )
    );
}
