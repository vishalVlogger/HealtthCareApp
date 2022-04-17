package com.example.loginsqlite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.loginsqlite.databinding.ActivityMainPageBinding;

import java.io.File;

public class MainPage extends AppCompatActivity {
    DatabaseHelper myDb;
    private static final String DB_PATH = "data/data/com.example.loginsqlite/database/healthcare.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        myDb = new DatabaseHelper(this);
        doDBCheck();
        AddData();
        Button bak = (Button) findViewById(R.id.bak);
        bak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void doDBCheck() {
        try {
            File file = new File(DB_PATH);
            file.delete();
        }catch (Exception ex){}
    }

    public void onDiseaseClick(View view) {
        if(view.getId() == R.id.Disease){
            Intent i = new Intent(MainPage.this, DiseaseActivity.class);
            startActivity(i);
        }
    }

    private void AddData() {
        myDb.deleteDiseaseData();
        myDb.deleteMedicineData();
        myDb.deleteTreatmentData();
        myDb.deleteSymptomsData();

        myDb.insertDiseaseData(01, "ASTHMA");
        myDb.insertMedicineData(01, "1 - Inhaled short-acting beta-2-agonists"+"\n"
                +"2 - Albuterol."+"\n"
                +"3 - Levalbuterol."+"\n"
                +"4 - Metaproterenol."+"\n"
                +"5 - Terbutaline."+"\n"
                +"6 - Proventil HFA"+"\n"
                +"7 - Xopenex.");
        myDb.insertTreatmentData(01, "1 - Breathing exercises increase the airflow in and out of the lungs – thereby neutralizing problems of asthma."+"\n"
                +"2 - Rescue or first aid treatments are the instant relief-providing medications used during an asthma attack. Options include rescue inhalers and nebulizers, bronchodilators (to relax tightened lung muscles), anti-inflammatory medications."+"\n"
                +"3 - Long-term asthma control medications are daily dosage that needs to be taken for years, to keep asthma under check."+"\n"
                +"4 - Bronchial thermoplasty is used for severe asthma where medications don’t work. In this type of bronchial asthma treatment, the doctor will heat up the insides of your lungs with electrodes which will smoothen the muscle inside the airways and reduce their ability to tighten, making it easier to breathe and reduce asthma symptoms.");
        myDb.insertSymptomsData(01, "1 - Shortness of breath."+"\n"
                +"2 - Chest tightness or pain."+"\n"
                +"3 - Wheezing when exhaling, which is a common sign of asthma in children."+"\n"
                +"4 - Trouble sleeping caused by shortness of breath, coughing or wheezing."+"\n"
                +"5 - Coughing or wheezing attacks that are worsened by a respiratory virus, such as a cold or the flu.");

        myDb.insertDiseaseData(02, "FEVER");
        myDb.insertTreatmentData(02, "1 -Take adequate rest"+"\n"
                +"2 - Consume Plenty of fluids ( fresh fruit juices, glucose, etc) to avoid dehydration"+"\n"
                +"3 - Use clean and boiled water"+"\n"
                +"4 - Easily digestible food is taken such as porridge, rice gruel, etc"+"\n"
                +"5 - OTC drugs such as paracetamol/ibuprofen effectively reduce fever");
        myDb.insertMedicineData(02, "1 - Calpol 250 mg tablet"+"\n"
                +"2 - Acetaminophen or Paracetamol. Acetaminophen or paracetamol helps to reduce fever and to relieve a headache with mild to moderate pain."+"\n"
                +"3 - Aspirin. Aspirin is an analgesic and antipyretic, prescribed for pain, heart attack and fever."+"\n"
                +"4 - Ibuprofen."+"\n"
                +"5 - Ketoprofen.");
        myDb.insertSymptomsData(02, "1 - Sweating."+"\n"
                +"2 - Chills and shivering."+"\n"
                +"3 - Headache."+"\n"
                +"4 - Muscle aches."+"\n"
                +"5 - Loss of appetite."+"\n"
                +"6 - Irritability."+"\n"
                +"7 - Dehydration."+"\n"
                +"8 - General weakness.");

        myDb.insertDiseaseData(03, "DENGUE");
        myDb.insertSymptomsData(03, "Primary symptoms of dengue appear three to 15 days after the mosquito bite and include the following:\n" +
                "\n" +
                " * high fever and severe headache, with severe pain behind the eyes that is apparent when trying to move the eyes.\n" +
                "* joint pain,\n" +
                "* muscle and bone pain,\n" +
                "* rash,\n" +
                "* mild bleeding.\n" +
                "* Many affected people complain of low back pain.");
        myDb.insertTreatmentData(03, "the treatment is concerned with relief of the symptoms and signs.\n \n * Home remedies such as rest and fluid intake (oral rehydration) are important. \n * Pain relievers such as aspirin and nonsteroidal anti-inflammatory drugs (NSAIDs) should only be taken under a doctor's supervision because of the possibility of worsening bleeding complications.\n * Acetaminophen (Tylenol) and codeine may be given for severe headache and for joint and muscle pain (myalgia).");
        myDb.insertMedicineData(03, "1 - Platorich Dengue Fever Tablet"+"\n"
                +"2 - Carica Papaya extract"+"\n"
                +"3 - Caripill Tablet"+"\n"
                +"4 - Senplet Dengue Tablet"+"\n"
                +"5 - Paracetamol tablet"+"\n"
                +"6 - Herbal Tonic for Dengue");

        myDb.insertDiseaseData(04, "CORONA");
        myDb.insertMedicineData(04, "1 - Corona vaccine"+"\n"
                +"2 - Remdesivir vaccine: a - An intravenously administered antiviral medication, it has been shown to be effective in well-designed studies.\nb - It seems to shorten recovery time and hospital stay but does not reduce the chance of death.\nc - It is currently to be used only in hospitalised patients with severe disease."+"\n"
                +"3 - Covishield Vaccine"+"\n"
                +"4 - Favipiravir tablet"+"\n"
                +"5 - Paracetamol tablet for fever");
        myDb.insertTreatmentData(04, "1 - Quarantine (Home/Hospital)"+"\n"
                +"2 - Frequent hand washing with soap and water for at least 40 seconds or clean with alcohol-based sanitizer."+"\n"
                +"3 - Ensure cleaning of surfaces in the room that are touched often (tabletops, doorknobs, handles, etc.) with 1% hypochlorite solution. \nMonitor temperature daily."+"\n"
                +"4 - Use a triple layer medical mask, discard mask after 8 hours of use or earlier if they become wet or visibly soiled.\nIn the event of a caregiver entering the room, both caregiver and patient may consider using N 95 mask."+"\n"
                +"5 - Don’t share personal items with other people in the household.");
        myDb.insertSymptomsData(04, "1 - Fever"+"\n"
                +"2 - Cough"+"\n"
                +"3 - Difficulty in breathing"+"\n"
                +"4 - Loss of taste or smell,\n\tNasal congestion,\n\tConjunctivitis (also known as red eyes),\n\tSore throat"+"\n"
                +"5 - Headache,\n\tMuscle or joint pain,\n\tDifferent types of skin rash,\n\tNausea or vomiting,\n\tDiarrhea,\n\tChills or dizziness.");

        myDb.insertDiseaseData(05,"FLU");
        myDb.insertMedicineData(05,"1 - Paracetamol 500MG"+"\n"
                +"2 - Crocin advance (Bodyache, Headache, Muscular ache, Backache, Neckache, Toothache, Period Pain)"+"\n"
                +"3 - B Jain Omeo Flu Tablets, 25 G"+"\n"
                +"4 - Antiflu 75 MG"+"\n"
                +"5 - Oseltamivir 75mg Capsules"+"\n"
                +"6 - Omeo Flu Bottle");
        myDb.insertTreatmentData(05,"1 - People with the flu should drink plenty of water and rest. Most people will recover within a week. \\nAntiviral drugs for influenza can reduce severe complications and deaths although influenza viruses can develop resistance to the drugs."+"\n"
                        +"2 - They are especially important for high-risk groups. Ideally these drugs need to be administered early (within 48 hours of onset of symptoms). Antibiotics are not effective against influenza viruses."+"\n"
                        +"3 - Flu is primarily treated with rest and fluid intake to allow the body to fight the infection on its own. \nParacetamol may help cure the symptoms but NSAIDs should be avoided. \nAn annual vaccine can help prevent the flu and limit its complications");
        myDb.insertSymptomsData(05,"1 - Fever"+"\n"
                +"2 - Runny nose"+"\n"
                +"3 - Stuffy nose"+"\n"
                +"4 - Headache"+"\n"
                +"5 - Body aches"+"\n"
                +"6 - Exhaustion"+"\n"
                +"7 - Sneezing, Cough");

        myDb.insertDiseaseData(06,"CANCER");
        myDb.insertMedicineData(06,"1 - Sorafenib / Sorafenib Nexavar Injection (200mg)"
                +"2 - Allopathic Tykerb 250 Mg Tablet"+"\n"
                +"3 - Cabita 500 Mg (Capecitabine Tablets IP)"+"\n"
                +"4 - Letrozole Letronat 2.5 MG Tablet"+"\n"
                +"5 - Anti Cancer Drug, For Hospital, 300mcg"+"\n"
                +"6 - Medicine Lenvima 10mg Capsules"+"\n"
                +"7 - Cervarix Injection(0.5 ml)");
        myDb.insertTreatmentData(06,"1 - Tata Memorial Hospital, Mumbai."+"\n"
                +"2 - Kidwai Memorial Institute of Oncology, Bangalore."+"\n"
                +"3 - Tata Memorial Hospital, Kolkata."+"\n"
                +"4 - Cancer Care Foundation of India, Mumbai."+"\n"
                +"5 - Treatments may include surgery, chemotherapy and radiation therapy.");
        myDb.insertSymptomsData(06,"1 - Unexplained weight loss. Are you losing weight without trying a diet, or exercising?"+"\n"
                +"2 - Body ache. Pain is usually caused by so many things that we don't usually link it with cancer."+"\n"
                +"3 - Viral fever."+"\n"
                +"4 - Fatigue."+"\n"
                +"5 - Skin problems."+"\n"
                +"6 - Swelling or bloating."+"\n"
                +"7 - Blood in cough, pee or stool." +"\n"
                +"8 - Persistent heartburn or indigestion.");

        myDb.insertDiseaseData(07,"MALARIA");
        myDb.insertMedicineData(07,"1 - Quinine and related agents."+"\n"
                +"2 - Chloroquine."+"\n"
                +"3 - Hydroxychloroquine."+"\n"
                +"4 - Amodiaquine."+"\n"
                +"5 - Pyrimethamine."+"\n"
                +"6 - Proguanil."+"\n"
                +"7 - Sulfonamides."+"\n"
                +"8 - Mefloquine.");
        myDb.insertTreatmentData(07,"1 -The best available treatment, particularly for P. falciparum malaria, is artemisinin-based combination therapy (ACT)."+"\n"
                +"2 - Treatment of P. vivax malaria (Confirmed P. vivax cases should be treated with chloroquine infull therapeutic dose of 25 mg/kg as per the age-wise dosage)"+"\n"
                +"3 - Treatment of P. falciparum malaria (Artemisinin Combination Therapy (ACT) should be givento all the confirmed P. falciparum cases found positive bymicroscopy or RDT. This is to be accompanied by single dose ofprimaquine (0.75 mg/kg body weight) on Day 2.)"+"\n"
                +"4 - Treatment of malaria in pregnancy (The ACT should be given for treatment of P. falciparum malariain second and third trimesters of pregnancy, while quinine isrecommended in the first trimester. Plasmodium vivax malaria canbe treated with chloroquine.)"+"\n"
                +"5 - Treatment of mixed infections (Mixed infections with P. falciparum  should be treated asfalciparum malaria. Since AS+SP is not effective in vivax malaria,other ACT should be used. However, anti-relapse treatment withprimaquine can be given for 14 days, if indicated.)"+"\n"
                +"6 - Avoid starting treatment on an empty stomach. The first doseshould be given under observation. \nDose should be repeated if vomiting occurs within half anhour of antimalarial intake."+"\n"
                +"7 - The patient should be asked to report back, if there is noimprovement after 48 hours or if the situation deteriorates. \nThe patient should also be examined and investigated forconcomitant illnesses.");
        myDb.insertSymptomsData(07,"1 - Chills"+"\n"
                +"2 - High fever."+"\n"
                +"3 - Headache."+"\n"
                +"4 - Profuse sweating."+"\n"
                +"5 - Vomiting."+"\n"
                +"6 - Nausea."+"\n"
                +"7 - Anemia."+"\n"
                +"8 - Muscle pain."+"\n"
                +"9 - Bloody Stool."+"\n"
                +"10 - Convulsions.");

        myDb.insertDiseaseData(8,"TYPHOID");
        myDb.insertMedicineData(8,"1 - Rightcef-O Tab"+"\n"
                +"2 - OFL-OZ Tablet"+"\n"
                +"3 - Cefpoglen tablet 200 DT"+"\n"
                +"4 - Gudcef Plus Tablet"+"\n"
                +"5 - Baptisia Q20 drop three times a day with some water"+"\n"
                +"6 - Baptisia 200 2drops three times a day");
        myDb.insertTreatmentData(8,"1 - Make sure you rest, drink plenty of fluids and eat regular meals. You may find it easier to eat smaller meals more frequently, rather than 3 larger meals a day."+"\n"
                +"2 - In hospital, you'll have antibiotic injections and you may also be given fluids and nutrients directly into a vein through an intravenous drip."+"\n"
                +"3 - You should also maintain good standards of personal hygiene, such as regularly washing your hands with soap and warm water, to reduce the risk of spreading the infection to others.");
        myDb.insertSymptomsData(8,"1 - Weakness."+"\n"
                +"2 - Stomach pain."+"\n"
                +"3 - Headache."+"\n"
                +"4 - Diarrhea or constipation."+"\n"
                +"5 - Cough."+"\n"
                +"6 - Loss of appetite.");


        Toast.makeText(MainPage.this, "Data Inserted", Toast.LENGTH_LONG).show();
    }

    public void onEmergencyClick(View view){
        if (view.getId() == R.id.Emergency){
            String phone = "+108";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            startActivity(intent);
        }
    }

}