package br.alunos.nolascopad2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import br.alunos.nolascopad2.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CadastroFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CadastroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView nometext;
    private TextView emailtext;
    private TextView senhatext;
    private TextView confirmatext;
    private Button cadbtn, lognewbtn;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CadastroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroFragment newInstance(String param1, String param2) {
        CadastroFragment fragment = new CadastroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        nometext = view.findViewById(R.id.nometext);
        emailtext = view.findViewById(R.id.emailtext);
        senhatext = view.findViewById(R.id.senhatext);
        confirmatext = view.findViewById(R.id.confirmatext);
        cadbtn = view.findViewById(R.id.cadbtn);
        lognewbtn = view.findViewById(R.id.newlogbtn);

        lognewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment fragment = new LoginFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelog,fragment);
                transaction.commit();
            }
        });

        /*cadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.nome = nometext.getText().toString();
                user.email = emailtext.getText().toString();
                user.senha = senhatext.getText().toString();
                String confirmasenha = confirmatext.getText().toString();
                if(user.nome==""||user.email==""||user.senha==""){
                    Toast.makeText(view.getContext(),"Campos foram deixados em branco",Toast.LENGTH_LONG).show();
                }
                else {
                    if(user.nome.length()>=5||user.email.length()>=12||user.senha.length()>=6){
                        if(user.email.contains("@")&&(user.email.contains(".com")||user.email.contains(".br"))){
                            if(!userDAO.searchUserByEmail(user.email)){
                                if(user.senha.equals(confirmasenha)){
                                    try {
                                        userDAO.saveUser(user);
                                        SharedPreferences preferences =  getActivity().getSharedPreferences(SAVED_USER, 0);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putInt("LoggedUserId", userDAO.getUserIDFromDBbyEmail(user.email));
                                        //Toast.makeText(getActivity().getApplicationContext(),"HMMMMM2",Toast.LENGTH_LONG).show();
                                        editor.commit();
                                        Log.w("Teste","User salvo");
                                        Intent intent = new Intent(LoginScreen.this,TimeLine.class);
                                        startActivity(intent);
                                        getActivity().finish();
                                    }catch (Exception e){
                                        Toast.makeText(getActivity().getApplicationContext(),"Não foi possivel efetuar o cadastro, veja o que deu errado aí, mas também pode ter sido erro nosso, então desculpa se for :)",Toast.LENGTH_LONG).show();
                                    }
                                } else Toast.makeText(getActivity().getApplicationContext(),"Senhas não batem",Toast.LENGTH_LONG).show();
                            }else  Toast.makeText(getActivity().getApplicationContext(),"Usuário já cadastrado",Toast.LENGTH_LONG).show();
                        }else Toast.makeText(getActivity().getApplicationContext(),"Email inválido inserido",Toast.LENGTH_LONG).show();
                    }else Toast.makeText(getActivity().getApplicationContext(),"Dados inválidos(Provavelmente por serem curtos demais)",Toast.LENGTH_LONG).show();
                }
            }
        });*/
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}