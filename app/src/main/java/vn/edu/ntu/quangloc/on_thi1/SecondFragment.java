package vn.edu.ntu.quangloc.on_thi1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import vn.edu.ntu.quangloc.controller.INgoaiTe;
import vn.edu.ntu.quangloc.controller.NgoaiTe;
import vn.edu.ntu.quangloc.model.NT;

public class SecondFragment extends Fragment {

    List<NgoaiTe> list;
    NgoaiTeAdapter adapter;
    RecyclerView rvNT;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addViews(v);
        return v;
    }

    private void addViews(View v) {
        rvNT = v.findViewById(R.id.rvNT);
        rvNT.setLayoutManager(new LinearLayoutManager(getContext()));
        list = ((INgoaiTe)getActivity().getApplication()).getAll();
        adapter = new NgoaiTeAdapter(list);
        rvNT.setAdapter(adapter);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    private class NgoaiTeViewHolder extends RecyclerView.ViewHolder{
        TextView txtDate, txtNT1, txtNT2, txtMua, txtBan;
//        ImageView imvAddToCart;
        NT p;
        private NgoaiTeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = this.itemView.findViewById(R.id.txtDate);
            txtNT1 = this.itemView.findViewById(R.id.txtNT1);
            txtNT2 = this.itemView.findViewById(R.id.txtNT2);
            txtMua = this.itemView.findViewById(R.id.txtMua);
            txtBan = this.itemView.findViewById(R.id.txtBan);
        }

        private void bind(NT p){
            this.p = p;
            txtDate.setText(p.getDate());
            txtNT1.setText(p.getType1());
            txtNT2.setText(p.getType2());
            txtMua.setText(String.format(Locale.ENGLISH, "Mua vào: %d", p.getMua()));
            txtBan.setText(String.format(Locale.ENGLISH, "Bán ra: %d", p.getBan()));
        }

    }

    private class NgoaiTeAdapter extends RecyclerView.Adapter<NgoaiTeViewHolder>{
        List<NgoaiTe> ngoaiTeList;

        private NgoaiTeAdapter(List<NgoaiTe> ngoaiTeList) {
            this.ngoaiTeList = ngoaiTeList;
        }

        @NonNull
        @Override
        public NgoaiTeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.ngoai_te, parent, false);
            // view: res/layout/product.xml
            return new NgoaiTeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NgoaiTeViewHolder holder, int position) {
            holder.bind(ngoaiTeList.get(position));
        }

        @Override
        public int getItemCount() {
            return ngoaiTeList.size();
        }
    }
}