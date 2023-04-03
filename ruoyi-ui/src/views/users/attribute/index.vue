<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="isUsed">
        <el-input
          v-model="queryParams.isUsed"
          placeholder="请输入是否使用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生日" prop="birthday">
        <el-date-picker clearable
          v-model="queryParams.birthday"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择生日">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="qq" prop="qqnum">
        <el-input
          v-model="queryParams.qqnum"
          placeholder="请输入qq"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信号" prop="wechatnum">
        <el-input
          v-model="queryParams.wechatnum"
          placeholder="请输入微信号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="展示标签id，绑定标签表" prop="uTableuse">
        <el-input
          v-model="queryParams.uTableuse"
          placeholder="请输入展示标签id，绑定标签表"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已获取标签id集合" prop="uTableids">
        <el-input
          v-model="queryParams.uTableids"
          placeholder="请输入已获取标签id集合"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入省"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="县、区" prop="area">
        <el-input
          v-model="queryParams.area"
          placeholder="请输入县、区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学校" prop="school">
        <el-input
          v-model="queryParams.school"
          placeholder="请输入学校"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否认证用户(no0;yes1)" prop="isAuth">
        <el-input
          v-model="queryParams.isAuth"
          placeholder="请输入是否认证用户(no0;yes1)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个性签名" prop="sign">
        <el-input
          v-model="queryParams.sign"
          placeholder="请输入个性签名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="绑定老师id" prop="teacherid">
        <el-input
          v-model="queryParams.teacherid"
          placeholder="请输入绑定老师id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否优评员" prop="isgoodcommons">
        <el-input
          v-model="queryParams.isgoodcommons"
          placeholder="请输入是否优评员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="积分" prop="integral">
        <el-input
          v-model="queryParams.integral"
          placeholder="请输入积分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['users:attribute:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['users:attribute:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['users:attribute:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['users:attribute:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="attributeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="isUsed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="性别" align="center" prop="sex" />
      <el-table-column label="生日" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="头像" align="center" prop="portrait" />
      <el-table-column label="qq" align="center" prop="qqnum" />
      <el-table-column label="微信号" align="center" prop="wechatnum" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="用户类型(默认：0；读者：1；作者：2；编辑：3；播音：4；教师：5；代理商：6)" align="center" prop="uType" />
      <el-table-column label="展示标签id，绑定标签表" align="center" prop="uTableuse" />
      <el-table-column label="已获取标签id集合" align="center" prop="uTableids" />
      <el-table-column label="省" align="center" prop="province" />
      <el-table-column label="市" align="center" prop="city" />
      <el-table-column label="县、区" align="center" prop="area" />
      <el-table-column label="学校" align="center" prop="school" />
      <el-table-column label="是否认证用户(no0;yes1)" align="center" prop="isAuth" />
      <el-table-column label="个性签名" align="center" prop="sign" />
      <el-table-column label="背景图" align="center" prop="background" />
      <el-table-column label="绑定老师id" align="center" prop="teacherid" />
      <el-table-column label="是否优评员" align="center" prop="isgoodcommons" />
      <el-table-column label="积分" align="center" prop="integral" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['users:attribute:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['users:attribute:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改用户属性对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否使用" prop="isUsed">
          <el-input v-model="form.isUsed" placeholder="请输入是否使用" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker clearable
            v-model="form.birthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择生日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="头像" prop="portrait">
          <el-input v-model="form.portrait" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="qq" prop="qqnum">
          <el-input v-model="form.qqnum" placeholder="请输入qq" />
        </el-form-item>
        <el-form-item label="微信号" prop="wechatnum">
          <el-input v-model="form.wechatnum" placeholder="请输入微信号" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="展示标签id，绑定标签表" prop="uTableuse">
          <el-input v-model="form.uTableuse" placeholder="请输入展示标签id，绑定标签表" />
        </el-form-item>
        <el-form-item label="已获取标签id集合" prop="uTableids">
          <el-input v-model="form.uTableids" placeholder="请输入已获取标签id集合" />
        </el-form-item>
        <el-form-item label="省" prop="province">
          <el-input v-model="form.province" placeholder="请输入省" />
        </el-form-item>
        <el-form-item label="市" prop="city">
          <el-input v-model="form.city" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="县、区" prop="area">
          <el-input v-model="form.area" placeholder="请输入县、区" />
        </el-form-item>
        <el-form-item label="学校" prop="school">
          <el-input v-model="form.school" placeholder="请输入学校" />
        </el-form-item>
        <el-form-item label="是否认证用户(no0;yes1)" prop="isAuth">
          <el-input v-model="form.isAuth" placeholder="请输入是否认证用户(no0;yes1)" />
        </el-form-item>
        <el-form-item label="个性签名" prop="sign">
          <el-input v-model="form.sign" placeholder="请输入个性签名" />
        </el-form-item>
        <el-form-item label="背景图" prop="background">
          <el-input v-model="form.background" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="绑定老师id" prop="teacherid">
          <el-input v-model="form.teacherid" placeholder="请输入绑定老师id" />
        </el-form-item>
        <el-form-item label="是否优评员" prop="isgoodcommons">
          <el-input v-model="form.isgoodcommons" placeholder="请输入是否优评员" />
        </el-form-item>
        <el-form-item label="积分" prop="integral">
          <el-input v-model="form.integral" placeholder="请输入积分" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listAttribute, getAttribute, delAttribute, addAttribute, updateAttribute } from "@/api/users/attribute";

export default {
  name: "Attribute",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 用户属性表格数据
      attributeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        isUsed: null,
        remarks: null,
        sex: null,
        birthday: null,
        portrait: null,
        qqnum: null,
        wechatnum: null,
        email: null,
        uType: null,
        uTableuse: null,
        uTableids: null,
        province: null,
        city: null,
        area: null,
        school: null,
        isAuth: null,
        sign: null,
        background: null,
        teacherid: null,
        isgoodcommons: null,
        integral: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户属性列表 */
    getList() {
      this.loading = true;
      listAttribute(this.queryParams).then(response => {
        this.attributeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        isUsed: null,
        createTime: null,
        updateTime: null,
        remarks: null,
        sex: null,
        birthday: null,
        portrait: null,
        qqnum: null,
        wechatnum: null,
        email: null,
        uType: null,
        uTableuse: null,
        uTableids: null,
        province: null,
        city: null,
        area: null,
        school: null,
        isAuth: null,
        sign: null,
        background: null,
        teacherid: null,
        isgoodcommons: null,
        integral: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户属性";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAttribute(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户属性";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAttribute(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAttribute(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除用户属性编号为"' + ids + '"的数据项？').then(function() {
        return delAttribute(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('users/attribute/export', {
        ...this.queryParams
      }, `attribute_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
